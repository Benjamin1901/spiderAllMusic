package com.itkim.pojo;

public class TbPlaylist {
    private Long playlistid;

    private String listtitle;

    private String listhref;

    private String photohref;

    private Integer ishot;

    public Long getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(Long playlistid) {
        this.playlistid = playlistid;
    }

    public String getListtitle() {
        return listtitle;
    }

    public void setListtitle(String listtitle) {
        this.listtitle = listtitle == null ? null : listtitle.trim();
    }

    public String getListhref() {
        return listhref;
    }

    public void setListhref(String listhref) {
        this.listhref = listhref == null ? null : listhref.trim();
    }

    public String getPhotohref() {
        return photohref;
    }

    public void setPhotohref(String photohref) {
        this.photohref = photohref == null ? null : photohref.trim();
    }

    public Integer getIshot() {
        return ishot;
    }

    public void setIshot(Integer ishot) {
        this.ishot = ishot;
    }
}