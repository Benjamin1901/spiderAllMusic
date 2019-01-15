package com.itkim.Main;

import com.itkim.pojo.TbComments;
import com.itkim.tools.EncryptUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * @author KimJun
 */
public class SpiderComment {

    public static void main(String[] args) throws Exception {
        getComment(100000L, 1, 1);
    }

    /**
     * 获取评论
     * @param songId 歌曲的id
     * @param pageFrom 从第这一页开始爬
     * @param pageEnd  爬到这一页
     * @throws Exception
     */
    public static void getComment(Long songId, int pageFrom, int pageEnd) throws Exception {
        for (int i = pageFrom; i <= pageEnd; i++) {
            Thread.sleep(3000 + (i % 2) * 1000);
            System.out.println(Thread.currentThread().getName() + i);
            String secKey = new BigInteger(100, new SecureRandom()).toString(32).substring(0, 16);
            String encText = EncryptUtils.aesEncrypt(EncryptUtils.aesEncrypt("{\"offset\":" + (i - 1) * 20 + ",\"limit\":" + 20 + "};", "0CoJUm6Qyw8W8jud"), secKey);
            String encSecKey = EncryptUtils.rsaEncrypt(secKey);
            Response execute = Jsoup
                    .connect("http://music.163.com/weapi/v1/resource/comments/R_SO_4_" + songId + "?csrf_token=")
                    .header("Referer", "http://music.163.com/song?id=" + songId)
                    .header("Cookie", "_ntes_nnid=b006c3a77c3852ebd7d6a8c1e1d140c4,1543164959783; _ntes_nuid=b006c3a77c3852ebd7d6a8c1e1d140c4; hb_MA-BFF5-63705950A31C_source=www.google.com.hk; nts_mail_user=15014537746@163.com:-1:1; locale=; mail_psc_fingerprint=3232bb94da41b0d580765b7934b21539; usertrack=CrHthVwK7EclAcmhAxcbAg==")
                    .data("params", encText)
                    .data("encSecKey", encSecKey)
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                    .header("Cache-Control", "no-cache")
                    .header("Accept", "*/*")
                    .header("Accept-Ecoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6")
                    .header("Connection", "keep-alive")
                    .header("Host", "music.163.com")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .method(Method.POST).ignoreContentType(true).timeout(2000000000).execute();
            String string = execute.body().toString();
            System.out.println(string);

            JSONObject j1 = new JSONObject(string);
            int total = j1.getInt("total");

            //如果有热评的字段，则解析热评的字段
            if (j1.has("hotComments")) {
                JSONArray j2 = j1.getJSONArray("hotComments");
                System.out.println(j2.length());
                //解析热评
                for (int j = 0; j < j2.length(); j++) {
                    JSONObject j3 = j2.getJSONObject(j);
                    JSONObject j4 = j3.getJSONObject("user");
                    TbComments comments = new TbComments();
                    comments.setComment(j3.getString("content"));
                    comments.setCommentid(j3.getLong("commentId"));
                    comments.setTime(j3.getLong("time"));
                    comments.setIshotcomments(1);
                    comments.setSongid(songId);
                    comments.setLikedcount(j3.getInt("likedCount"));
                    comments.setAvatarurl(j4.getString("avatarUrl"));
                    comments.setUserid(j4.getLong("userId"));
                    comments.setNickname(j4.getString("nickname"));
                    comments.setCommentnum(total);
                    System.out.println(comments.toString());
                }
                //解析第一页的评论
                Analytical(j1,songId,total);
            }else {
                //解析第一页后的评论
                Analytical(j1,songId,total);
            }
        }
    }

    /**
     * 解析非热评的评论
     * @param object 评论，json格式数据
     * @param songId 歌曲的id
     * @param total 评论的总数
     */
    public static void Analytical(JSONObject object, Long songId, int total) {
        //解析第一页的评论
        JSONArray j3 = object.getJSONArray("comments");
        for (int k = 0; k < j3.length(); k++) {
            JSONObject j4 = j3.getJSONObject(k);
            JSONObject j5 = j4.getJSONObject("user");
            TbComments comments = new TbComments();
            comments.setComment(j4.getString("content"));
            comments.setCommentid(j4.getLong("commentId"));
            comments.setTime(j4.getLong("time"));
            comments.setIshotcomments(0);
            comments.setSongid(songId);
            comments.setLikedcount(j4.getInt("likedCount"));
            comments.setAvatarurl(j5.getString("avatarUrl"));
            comments.setUserid(j5.getLong("userId"));
            comments.setNickname(j5.getString("nickname"));
            comments.setCommentnum(total);
            System.out.println(comments.toString());
        }
    }
}