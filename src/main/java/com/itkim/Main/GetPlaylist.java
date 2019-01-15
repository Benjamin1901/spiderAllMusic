package com.itkim.Main;

import com.itkim.dao.TbPlaylistMapper;
import com.itkim.dao.TbPlaylistMusicMapper;
import com.itkim.pojo.TbPlaylist;
import com.itkim.pojo.TbPlaylistMusic;
import com.itkim.tools.DBTools;
import com.itkim.tools.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 获取歌单
 * @author: KimJun
 * @date: 19/1/8 13:06
 */
public class GetPlaylist {

    private static SqlSession session = DBTools.getSession();
    private static TbPlaylistMapper mapper = session.getMapper(TbPlaylistMapper.class);
    private static TbPlaylistMusicMapper mapper3 = session.getMapper(TbPlaylistMusicMapper.class);


    /**
     * 获取歌单里面的歌曲数据
     * @param url 接口的链接
     * @return 返回json的数据
     * @throws IOException
     */
    public static ArrayList getSong(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        httpget.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        httpget.addHeader("Host", "music.163.com");
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity);
        Document document = Jsoup.parse(html);

        //创建任务队列
        ArrayList<String> bq = new ArrayList();

        Elements element = document.select("ul[class=f-hide] a");
        for (Element element1 : element) {
            long songId = Long.parseLong(element1.attr("href").replace("/song?id=", ""));
            bq.add("http://music.163.com/api/song/detail/?id=" + songId + "&ids=%5B+" + songId + "%5D");
        }
        return bq;
    }

    /**
     * 获取热门歌单的数据
     *
     * @param url https://music.163.com/discover/playlist/?order=new&cat=%E5%85%A8%E9%83%A8&limit=35&offset=" + i * 35
     * @return
     * @throws IOException
     */
    public static void getPlayList(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        httpget.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        httpget.addHeader("Host", "music.163.com");
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity);
        Document document = Jsoup.parse(html);
        Elements element = document.select("#m-pl-container > li > div");


        for (Element element1 : element) {
            TbPlaylist playlist = new TbPlaylist();
            Elements element2 = element1.select("a");
            Elements element3 = element1.select("img");
            System.out.println(element2.attr("title"));
            System.out.println(element2.attr("href"));
            System.out.println(element3.attr("src"));

            playlist.setIshot(0);
            playlist.setListtitle(element2.attr("title"));
            playlist.setPhotohref(element3.attr("src"));
            playlist.setListhref("https://music.163.com" + element2.attr("href"));
            playlist.setPlaylistid(Long.parseLong(element2.attr("href").replace("/playlist?id=", "")));
            mapper.insert(playlist);
            session.commit();
        }
    }


    public static void main(String[] args)  {


        List<TbPlaylist> list = mapper.selectByExample(null);


        //list 4000次循环 78出了问题了， 需要解决
        for (int i = 87; i <= list.size(); i++) {
            long playlistId = list.get(i).getPlaylistid();
            String listhref = list.get(i).getListhref();

            ArrayList list1 = null;
            try {
                list1 = GetPlaylist.getSong(listhref);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int j = 0; j <= list1.size(); j++) {
                System.out.println("当前:" + i);

                try {
                    //任务出队
                    String infoUrl = list1.get(j).toString();
                    System.out.println("size: " + list1.size() + " 任务url：" + infoUrl );
                    System.out.println("j == " + j);
                    TbPlaylistMusic music = new TbPlaylistMusic();

                    music.setPlaylistid(playlistId);

                    if (null != infoUrl) {
                        String songId1 = null;
                        System.out.println(infoUrl);
                        if (infoUrl.length() == 55) {
                            songId1 = (String) infoUrl.subSequence(41, 42);
                        } else if (infoUrl.length() == 57) {
                            songId1 = (String) infoUrl.subSequence(41, 43);
                        } else if (infoUrl.length() == 59) {
                            songId1 = (String) infoUrl.subSequence(41, 44);
                        } else if (infoUrl.length() == 61) {
                            songId1 = (String) infoUrl.subSequence(41, 45);
                        } else if (infoUrl.length() == 63) {
                            songId1 = (String) infoUrl.subSequence(41, 46);
                        } else if (infoUrl.length() == 65) {
                            songId1 = (String) infoUrl.subSequence(41, 47);
                        } else if (infoUrl.length() == 67) {
                            songId1 = (String) infoUrl.subSequence(41, 48);
                        } else if (infoUrl.length() == 69) {
                            songId1 = (String) infoUrl.subSequence(41, 49);
                        } else if (infoUrl.length() == 71) {
                            songId1 = (String) infoUrl.subSequence(41, 50);
                        } else if (infoUrl.length() == 73) {
                            songId1 = (String) infoUrl.subSequence(41, 51);
                        } else if (infoUrl.length() == 75) {
                            songId1 = (String) infoUrl.subSequence(41, 52);
                        } else if (infoUrl.length() == 77) {
                            songId1 = (String) infoUrl.subSequence(41, 53);
                        } else if (infoUrl.length() == 79) {
                            songId1 = (String) infoUrl.subSequence(41, 54);
                        } else if (infoUrl.length() == 81) {
                            songId1 = (String) infoUrl.subSequence(41, 55);
                        }


                        long songId = Long.parseLong(songId1);
                        music.setSongid(songId);

                        System.out.println("当前的id --->" + songId);
                        String urlsource = HttpClient.get(infoUrl);
                        System.out.println(urlsource);
                        String outerUrl = "http://music.163.com/song/media/outer/url?id=" + songId + ".mp3";
                        //如果服务成功 才进行解析json数据
                        if (urlsource.length() > 200) {
                            System.out.println(urlsource);
                            JSONObject j1 = new JSONObject(urlsource);
                            JSONArray j2 = j1.getJSONArray("songs");

                            System.out.println("--------");
                            JSONObject j3 = j2.getJSONObject(0);
                            String songName = j3.get("name").toString();

                            JSONArray j4 = j3.getJSONArray("artists");
                            System.out.println("j4  " + j4.toString());
                            JSONObject j5 = j4.getJSONObject(0);
                            String songSinger = j5.get("name").toString();
                            String url = "https://music.163.com/#/song?id=" + songId;
                            music.setOuterurl(outerUrl);
                            music.setSongname(songName);
                            music.setSongsinger(songSinger);
                            music.setSongurl(url);
                            System.out.println(songName);

                            //如果歌名不是"错误引导”就插入数据库
                            if (!songName.equals("错误引导")) {
//                                    mapper3.insert(new TbAllMusic((long) songId, songName, songSinger, url, outerUrl));
                                mapper3.insert(music);
                                session.commit();
                                System.out.println("提交成功");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
