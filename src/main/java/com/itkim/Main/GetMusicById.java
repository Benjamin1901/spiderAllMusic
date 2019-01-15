package com.itkim.Main;

import com.itkim.dao.TbAllMusicMapper;
import com.itkim.tools.DBTools;
import com.itkim.tools.HttpClient;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 通过遍历id的方法去爬取歌曲从id=1000 ---> id=2220000
 * @author: KimJun
 * @date: 18/12/29 16:39
 */
public class GetMusicById {


    private static SqlSession session = DBTools.getSession();
    private static TbAllMusicMapper mapper = session.getMapper(TbAllMusicMapper.class);



    @Test
    public void test() {
        try {
            System.out.println(HttpClient.get("https://music.163.com/artist?id=10559"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加任务到队列里
     */
    public static void queue() {

    }

    public static void main(String[] args) {

        //创建任务队列
        ArrayBlockingQueue<String> bq = new ArrayBlockingQueue(52001);
        //爬到1000---2700000
        for (int songId = 2700000; songId <= 2700000; songId++) {
            bq.add("http://music.163.com/api/song/detail/?id=" + songId + "&ids=%5B+" + songId + "%5D");
            System.out.println(songId);
        }

        //创建线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(200);

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
                            System.out.println(infoUrl);
                            String songId1 = (String) infoUrl.subSequence(41, 48);
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
                            }else {
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