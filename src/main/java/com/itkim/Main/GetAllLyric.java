package com.itkim.Main;

import com.itkim.dao.TbAllMusicMapper;
import com.itkim.pojo.TbAllMusic;
import com.itkim.tools.DBTools;
import com.itkim.tools.HttpClient;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 获取歌词
 * api http://music.163.com/api/song/lyric?os=pc&id=186860&lv=-1&kv=-1&tv=-1
 * @author: KimJun
 * @date: 19/1/10 19:36
 */
public class GetAllLyric {

    private static SqlSession session = DBTools.getSession();
    private static TbAllMusicMapper mapper = session.getMapper(TbAllMusicMapper.class);


    public static String getAllLyric(String link) throws IOException {
        String json = HttpClient.get(link);
        JSONObject jsonObject = new JSONObject(json);
        String lyric = jsonObject.getJSONObject("lrc").getString("lyric").replaceAll("\\[.*?\\]", "");
        System.out.println(lyric);
        return lyric;
    }

    public static void main(String[] args) throws IOException {

        ArrayBlockingQueue<String> bq = new ArrayBlockingQueue(1400000);
        List<TbAllMusic> musics = mapper.selectByExample(null);
        for (int i = 368890; i < musics.size(); i++) {
            Long songId = musics.get(i).getSongid();
            bq.add("http://music.163.com/api/song/lyric?os=pc&id=" + songId + "&lv=-1&kv=-1&tv=-1");
        }
        System.out.println("添加完成！");

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(200);
        while (!bq.isEmpty()) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String href = bq.poll();
                        String lyric = getAllLyric(href);
                        Long songId = Long.parseLong(href.replace("http://music.163.com/api/song/lyric?os=pc&id=","").replace("&lv=-1&kv=-1&tv=-1",""));
                        TbAllMusic music = new TbAllMusic();
                        music.setSongid(songId);
                        music.setLyric(lyric);

                        mapper.updateByPrimaryKeySelective(music);
                        session.commit();
                        System.out.println(songId);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fixedThreadPool.shutdown();
                }
            });
        }
    }
}
