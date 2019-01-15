package com.itkim.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;

import java.util.List;

/**
 * @description: TODO
 * @author: KimJun
 * @date: 19/1/10 00:49
 */
public class Music163Processer2 implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    /**
     * 抓取的歌手分组（日本歌手、欧美歌手、韩国歌手、其他）
     */
    private static final String URL_LIST = "https://music\\.163\\.com/discover/artist$";
    /**
     * 某一个歌手分组的所有歌手 id 歌手分组
     */
    private static final String SINGER_LIST = "https://music\\.163\\.com/discover/artist/cat\\?id=\\d+";

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(URL_LIST).match()) {
            List<String> strings =page.getHtml().$("#m-artist-box > li > a.nm.nm-icn.f-thide.s-fc0", "title").all();
            System.out.println(strings.size() + "--------->");
        }
    }

    @Override
    public Site getSite() {
        return null;
    }

    public static void main(String[] args) {
        Spider.create(new Music163Processer()).addUrl("https://music.163.com/discover/artist")
                .setScheduler(new QueueScheduler())
                .thread(2).addPipeline(new ConsolePipeline()).run();
    }
}
