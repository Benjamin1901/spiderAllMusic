package com.itkim.Main;

import com.itkim.dao.TbAllMusicMapper;
import com.itkim.dao.TbAllSingerMapper;
import com.itkim.pojo.TbAllSinger;
import com.itkim.tools.DBTools;
import com.itkim.tools.HttpClient;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 通过歌手的表去获取每个歌手的热门歌曲信息
 * @author: KimJun
 * @date: 19/1/10 17:14
 */
public class GetAllHotSong {

    private static SqlSession session = DBTools.getSession();
    private static TbAllMusicMapper mapper = session.getMapper(TbAllMusicMapper.class);
    private static TbAllSingerMapper mapper2 = session.getMapper(TbAllSingerMapper.class);

    /**
     * 解析json数据
     * @param html
     * @return
     * @throws IOException
     */
    public static String getAllHotSong(String html) throws IOException {
        String result = HttpClient.get(html);
        Document document = Jsoup.parse(result);
        Elements elements = document.select("#song-list-pre-data");
        String resJson = elements.text();
        if (resJson != null) {
            return resJson;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

        ArrayBlockingQueue<String> bq = new ArrayBlockingQueue(20000);

        List<TbAllSinger> singers = mapper2.selectByExample(null);
        for (int i = 0; i < singers.size(); i++) {
            String href = singers.get(i).getSingerhref();
            bq.add(href);
        }
        System.out.println("添加成功！！");

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);
        while (!bq.isEmpty()) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String json = getAllHotSong(bq.poll());
                        if (json != null) {
                            JSONArray array = new JSONArray(json);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = new JSONObject(array.get(i).toString());
                                Long songId = Long.parseLong(object.getInt("id") + "");
                                String songName = object.getString("name");

                                JSONArray array1 = object.getJSONArray("artists");
                                JSONObject object2 = new JSONObject(array1.get(0).toString());
                                String singer = object2.getString("name");
                                String songUrl = "https://music.163.com/#/song?id=" + songId;
                                String outerUrl = "http://music.163.com/song/media/outer/url?id=" + songId + ".mp3";
                                System.out.println(singer);
                                System.out.println(songName);
                                System.out.println(songId);

//                                mapper.insert(new TbAllMusic(songId, songName, singer, songUrl, outerUrl));
                                session.commit();
                                System.out.println("添加成功！！");
                            }
                        }
                        fixedThreadPool.shutdown();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
