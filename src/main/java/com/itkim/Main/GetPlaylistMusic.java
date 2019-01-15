package com.itkim.Main;

import com.itkim.dao.TbAllMusicMapper;
import com.itkim.dao.TbPlaylistMapper;
import com.itkim.pojo.TbPlaylist;
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
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 爬取歌单里面的歌曲存到所有音乐的表中
 * @author: KimJun
 * @date: 19/1/9 11:57
 */
public class GetPlaylistMusic {

    private static SqlSession session = DBTools.getSession();
    private static TbAllMusicMapper mapper = session.getMapper(TbAllMusicMapper.class);
    private static TbPlaylistMapper mapper2 = session.getMapper(TbPlaylistMapper.class);

    //创建任务队列
    private static ArrayBlockingQueue<String> bq = new ArrayBlockingQueue(50000);

    public static void getSong(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        httpget.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        httpget.addHeader("Host", "music.163.com");
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity);
        Document document = Jsoup.parse(html);


        Elements element = document.select("ul[class=f-hide] a");
        for (Element element1 : element) {
            long songId = Long.parseLong(element1.attr("href").replace("/song?id=", ""));
            bq.add("http://music.163.com/api/song/detail/?id=" + songId + "&ids=%5B+" + songId + "%5D");
        }
        System.out.println("添加成功！");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        List<TbPlaylist> list = mapper2.selectByExample(null);


        for (int i = 1; i <= 10000; i++) {
            getSong(list.get(i).getListhref());
            System.out.println("当前的歌单数 ： " + i);
            System.out.println("任务队列的数目：" + bq.size());
//            Thread.sleep(3000);
        }

        //创建线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);

        while (!bq.isEmpty()) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
//                    String infoUrl = "http://music.163.com/api/song/detail/?id=" + songId + "&ids=%5B+" + songId + "%5D";
                    try {
                        String infoUrl = null;
                        //任务出队
                        infoUrl = bq.poll();
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
                            }

                            System.out.println(infoUrl);
                            int songId = Integer.parseInt(songId1);
                            System.out.println("当前的id --->" + songId);
                            String urlsource = null;
                            urlsource = HttpClient.get(infoUrl);
                            System.out.println(urlsource);
                            String outerUrl = "http://music.163.com/song/media/outer/url?id=" + songId + ".mp3";
                            //如果服务成功 才进行解析json数据
                            if (urlsource.length() > 200) {
                                System.out.println(urlsource);
                                JSONObject j1 = new JSONObject(urlsource);
                                JSONArray j2 = j1.getJSONArray("songs");

                                JSONObject j3 = j2.getJSONObject(0);
                                String songName = j3.get("name").toString();

                                JSONArray j4 = j3.getJSONArray("artists");
                                System.out.println("j4  " + j4.toString());
                                JSONObject j5 = j4.getJSONObject(0);
                                String songSinger = j5.get("name").toString();
                                String url = "https://music.163.com/#/song?id=" + songId;
                                System.out.println(songName);

                                //如果歌名不是"错误引导”就插入数据库
                                if (!songName.equals("错误引导")) {
//                                    mapper.insert(new TbAllMusic((long) songId, songName, songSinger, url, outerUrl));
                                    session.commit();
                                    System.out.println("提交成功");
                                }
                                //线程用完就删
                                fixedThreadPool.shutdown();
                            } else {
                                //线程用完就删
                                fixedThreadPool.shutdown();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
