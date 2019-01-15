package com.itkim.webmagic;

import com.itkim.webmagic.bean.AlbumInfo;
import com.itkim.webmagic.bean.MusicInfo;
import com.itkim.webmagic.bean.SingerInfo;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cj34920
 * Date: 2018/06/19
 */
public class Music163Processer implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    /**
     * 抓取的歌手分组（日本歌手、欧美歌手、韩国歌手、其他）
     */
    private static final String URL_LIST = "https://music\\.163\\.com/discover/artist$";
    /**
     * 某一个歌手分组的所有歌手 id 歌手分组
     */
    private static final String SINGER_LIST = "https://music\\.163\\.com/discover/artist/cat\\?id=\\d+";
    /**
     * 某一个歌手分组的所有歌手 initial 歌手姓名ABCDEFG
     */
    private static final String SINGER_NAME_LIST = "https://music\\.163\\.com/discover/artist/cat\\?id=\\d+\\&initial=\\d+";
    /**
     * 某一歌手所有专辑
     */
    private static final String ALBUM_LIST = "https://music\\.163\\.com/artist/album\\?id=(\\d+)$";
    /**
     * 某一歌手所有专辑(分页)
     */
    private static final String ALBUM_PAGE_LIST = "https://music\\.163\\.com/artist/album\\?id=\\d+\\&limit=\\d+\\&offset=\\d+";
    /**
     * 某一歌手某一专辑所有歌曲
     */
    private static final String ALBUM_DETAIL = "https://music\\.163\\.com/album\\?id=\\d+";
    /**
     * 歌曲地址  id 歌曲id
     */
    private static final String SONGNADDRESS = "https://music\\.163\\.com/song\\?id=(\\d+)";
    /**
     * 获取评论地址
     */
    private static final String COMMENT = "https://music\\.163\\.com/weapi/v1/resource/comments/*+";
    /**
     * 正则匹配歌手id
     */
    private static final String SINGER_ID_REGEX = "artist\\?id=(\\d*)";
    /**
     * 正则匹配歌手id
     */
    private static final String SONG_ID_REGEX = "song\\?id=(\\d*)";

    /**
     * 正则匹配歌曲id 通过匹配评论地址url
     */
    private static final String SONG_ID = "R_SO_4_(\\d+)";
    /***
     * 密钥
     */
    private static String sKey = "0CoJUm6Qyw8W8jud";

    Pattern compile = Pattern.compile(SINGER_ID_REGEX);
    Pattern compileSong = Pattern.compile(SONG_ID_REGEX);
    Pattern songId = Pattern.compile(SONG_ID);
    Pattern albumSingerId = Pattern.compile(ALBUM_LIST);
    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(URL_LIST).match()) {
            List<String> groupHref = page.getHtml().xpath("//div[@class ='blk']//li/a[@class='cat-flag']/@href").all();
            page.addTargetRequests(groupHref);
            return;
        }
        //sdsd
        else if (page.getUrl().regex(SINGER_LIST).match()) {
            List<String> surNameList = page.getHtml().xpath("//ul[@id='initial-selector']/li/a/@href").all();
            page.addTargetRequests(surNameList.subList(1, surNameList.size()));
            return;
        } else if (page.getUrl().regex(SINGER_NAME_LIST).match()) {
            List<String> singerListHref = page.getHtml().xpath("//div[@class='m-sgerlist']/ul[@id='m-artist-box']/li[@class='sml']/a/@href").all();
            List<String> singerListIamgeHref = page.getHtml().xpath("//div[@class='m-sgerlist']/ul[@id='m-artist-box']/li/p/a/@href").all();
            singerListHref.addAll(singerListIamgeHref);
            for (String singerHref : singerListHref) {
                Matcher matcher = compile.matcher(singerHref);
                if (matcher.find()) {
                    String singerId = matcher.group(1);
                    page.addTargetRequest("https://music.163.com/artist/album?id=" + singerId);
                }
            }
            return;
        } else if (page.getUrl().regex(ALBUM_LIST).match() || page.getUrl().regex(ALBUM_PAGE_LIST).match()) {
            List<String> albumList = page.getHtml().xpath("//ul[@id='m-song-module']/li//p/a/@href").all();
            if (albumList.size() < 0) {
                return;
            }
            //只有是第一次才需要记录歌手信息
            if (page.getUrl().regex(ALBUM_LIST).match()) {
                //通过这种方式获取id可以防止专辑为空的情况
                String singerId = "0";
                Matcher matcher = albumSingerId.matcher(page.getUrl().toString());
                while (matcher.find()) {
                    singerId = matcher.group(1);
                }
                //获取歌手信息
                String singerName = page.getHtml().xpath("//h2[@id='artist-name']/text()").toString();
                String description = page.getHtml().xpath("//meta[@name='description']/@content").toString();
                SingerInfo singerInfo = new SingerInfo();
                singerInfo.setSingerDescription(description == null ? "" : description);
                singerInfo.setSingerId(Integer.valueOf(singerId));
                singerInfo.setSingerName(singerName == null ? "" : singerName);
                singerInfo.setCreateTime(df.format(new Date()));
                singerInfo.setSingerHref("https://music.163.com/artist?id=" + singerId);
                singerInfo.toString();
                System.out.println(singerInfo.toString());
                page.putField("singerInfo", singerInfo);
            }

            //分页数据
            List<String> albumListNext = page.getHtml().xpath("//div[@class='u-page']/a[@class='zpgi']/@href").all();
            if (albumListNext.size() > 1) {
                page.addTargetRequests(albumListNext.subList(1, albumListNext.size()));
            } else {
                page.addTargetRequests(albumListNext);
            }
            page.addTargetRequests(albumList);
            return;
        } else if (page.getUrl().regex(ALBUM_DETAIL).match()) {
            List<String> singList = page.getHtml().xpath("//div[@id='song-list-pre-cache']//ul[@class='f-hide']/li/a/@href").all();
            String albumId = page.getHtml().xpath("//div[@id='content-operation']/@data-rid").toString();
            String albumName = page.getHtml().xpath("//div[@class='tit']/[@class='f-ff2']/text()").toString();
            String albumTime = page.getHtml().xpath("////div[@class='topblk']/p[2]/text()").toString();
            String albumCompany = page.getHtml().xpath("//div[@class='topblk']/p[3]/text()").toString();
            String albumSingerName = page.getHtml().xpath("//p[@class='intr']//a[@class='s-fc7']/text()").toString();
            String albumSingerId = "";
            String albumSingerHref = page.getHtml().xpath("//p[@class='intr']//a[@class='s-fc7']/@href").toString();
            if (albumSingerHref != null) {
                Matcher matcher = compile.matcher(albumSingerHref);
                if (matcher.find()) {
                    albumSingerId = matcher.group(1);
                }
            }
            AlbumInfo albumInfo = new AlbumInfo();
            albumInfo.setAlbumId(Integer.valueOf(albumId));
            albumInfo.setAlbumName(albumName);
            albumInfo.setAlbumTime(albumTime);
            albumInfo.setAlbumCompany(albumCompany);
            albumInfo.setAlbumSingerName(albumSingerName);
            albumInfo.setAlbumSingerId(albumSingerId);
            System.out.println(albumInfo.toString());
            page.putField("albumInfo", albumInfo);
            return;
            //获取专辑详情
//            page.addTargetRequests(singList);
        } else if (page.getUrl().regex(SONGNADDRESS).match()) {
            String songName = page.getHtml().xpath("//div[@class='tit']/em[@class='f-ff2']/text()").toString();
            String singerName = page.getHtml().xpath("//p[@class='des s-fc4']/span/a/text()").toString();
            String ablumName = page.getHtml().xpath("//p[@class='des s-fc4']/a/text()").toString();
            Matcher matcher = compileSong.matcher(page.getUrl().toString());
            if (matcher.find()) {
                String songId = matcher.group(1);
                MusicInfo musicInfo = new MusicInfo();
                musicInfo.setSongId(songId);
                musicInfo.setAlbum(ablumName);
                musicInfo.setTitle(songName);
                musicInfo.setAuthor(singerName);
                musicInfo.setURL(page.getUrl().toString());
                System.out.println(musicInfo.toString());
                page.putField("musicInfo", musicInfo);
            }
            return;
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new Music163Processer()).addUrl("https://music.163.com/discover/artist")
                .setScheduler(new QueueScheduler())
                .thread(2).addPipeline(new ConsolePipeline()).run();
    }

    /**
     * @param songId     歌曲ID
     * @param paging     是否第一页 true 第一页  其余传入false
     * @param nowPageNum 当前页数
     * @return
     */
    public static String makeContent(String songId, String paging, int nowPageNum) {
        int offset;
        if (nowPageNum < 1) {
            offset = 20;
        }
        offset = (nowPageNum - 1) * 20;
        String baseContent = "{rid: \"R_SO_4_%s\",offset: \"%d\",total: \"%s\",limit: \"20\",csrf_token: \"\"}";
        return String.format(baseContent, songId, offset, paging);
    }

    /**
     * 将时间戳转换为时间
     *
     * @param s
     * @return
     */
    public static String stampToDate(long s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = s;
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
