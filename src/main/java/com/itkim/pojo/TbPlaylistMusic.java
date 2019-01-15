package com.itkim.pojo;

public class TbPlaylistMusic extends TbPlaylistMusicKey {
    private String songname;

    private String songsinger;

    private String songurl;

    private String outerurl;

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname == null ? null : songname.trim();
    }

    public String getSongsinger() {
        return songsinger;
    }

    public void setSongsinger(String songsinger) {
        this.songsinger = songsinger == null ? null : songsinger.trim();
    }

    public String getSongurl() {
        return songurl;
    }

    public void setSongurl(String songurl) {
        this.songurl = songurl == null ? null : songurl.trim();
    }

    public String getOuterurl() {
        return outerurl;
    }

    public void setOuterurl(String outerurl) {
        this.outerurl = outerurl == null ? null : outerurl.trim();
    }
}