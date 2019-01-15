package com.itkim.Main;

import com.itkim.dao.TbAllSingerMapper;
import com.itkim.pojo.TbAllSinger;
import com.itkim.tools.DBTools;
import com.itkim.tools.HttpClient;
import org.apache.ibatis.session.SqlSession;
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
 * @description: 爬取所有的歌手信息 不包括日韩。
 * @author: KimJun
 * @date: 19/1/10 10:38
 */
public class GetAllSinger {

    private static SqlSession session = DBTools.getSession();
    private static TbAllSingerMapper mapper = session.getMapper(TbAllSingerMapper.class);



    /**
     * 获取所有的歌手
     * @param html
     * @throws IOException
     */
    public static void getAllSinger(String html) throws IOException {
        String result = HttpClient.get(html);
        Document document = Jsoup.parse(result);
        Elements elements = document.select("#m-artist-box > li > a.nm.nm-icn.f-thide.s-fc0");
        for (Element elements1 : elements) {
            System.out.println(elements1.attr("href"));
            System.out.println(elements1.text());

            TbAllSinger singer = new TbAllSinger();
            String singHref = elements1.attr("href");

            singer.setSingerhref("https://music.163.com" + singHref);
            singer.setSingername(elements1.text());
            singer.setSingerid(Long.parseLong(elements1.attr("href").replace("/artist?id=", "")));
            mapper.insertSelective(singer);
        }

        Elements elements1 = document.select("#m-artist-box > li > div > a");
        for (Element element : elements1) {
            System.out.println(element.attr("title").replace("的音乐", ""));
            System.out.println(element.attr("href"));

            TbAllSinger singer = new TbAllSinger();
            String singHref = element.attr("href");

            singer.setSingerhref("https://music.163.com" + singHref);
            singer.setSingername(element.attr("title").replace("的音乐", ""));
            singer.setSingerid(Long.parseLong(element.attr("href").replace("/artist?id=", "")));
            mapper.insertSelective(singer);
        }

        session.commit();
    }


    /**
     * 获取所有的专辑 没写完
     * @param html
     * @throws IOException
     * @throws InterruptedException
     */
    public static void getAllAlbum(String html) throws IOException {
        String result = HttpClient.get(html);
        Document document = Jsoup.parse(result);
        Elements elements = document.select("#m-song-module > li > p.dec.dec-1.f-thide2.f-pre > a");
        for (Element element : elements) {
            String albumHref = element.attr("href");
            String albumName = element.text();
            System.out.println(albumHref + "  " + albumName);
        }

    }

    /**
     * 获取歌手介绍
     * @param html
     * @return
     * @throws IOException
     */
    public static String getSingerInfo(String html) throws IOException {
        String result = HttpClient.get(html);
        Document document = Jsoup.parse(result);
        Elements elements = document.select("div.g-bd4.f-cb > div.g-mn4 > div > div > div:nth-child(3) > div");
        String str = null;
        for (Element element : elements) {
            System.out.println(element.toString());
            str = element.toString();
        }
        return str;
    }

    public static void main(String[] args) throws IOException {
        //获取所有的华语男歌手 A--Z
//        for (int i = 65; i <= 90; i++){
//            getAllSinger("https://music.163.com/discover/artist/cat?id=1001&initial=" + i );
//            System.out.println("当前的页数：" + i);
//            Thread.sleep(2000);
//
//        }
        //其他华语男歌手
//        getAllSinger("https://music.163.com/discover/artist/cat?id=1001&initial=0");



        //多线程爬取歌手的消息
        //创建任务队列
        ArrayBlockingQueue<String> bq = new ArrayBlockingQueue(52001);
        List<TbAllSinger> singers = mapper.selectByExample(null);
        for (int i = 0; i < 14957; i++) {
            Long singerId = singers.get(i).getSingerid();
            bq.add("https://music.163.com/artist/desc?id=" + singerId);
        }
        System.out.println("添加完成！");

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(200);
        while (!bq.isEmpty()) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {

                    try {
                        TbAllSinger singer = new TbAllSinger();
                        String url = bq.poll();
                        singer.setSingerid(Long.parseLong(url.replace("https://music.163.com/artist/desc?id=","")));
                        String singerInfo = getSingerInfo(url);
                        singer.setSingerdesc(singerInfo);
                        mapper.updateByPrimaryKeySelective(singer);
                        session.commit();
                        System.out.println("提交成功！");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fixedThreadPool.shutdown();
                }
            });
        }
    }
}
