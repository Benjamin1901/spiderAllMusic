package com.itkim.pojo;

public class TbAllSinger {
    private Long singerid;

    private String singername;

    private String singerhref;

    private String singerdesc;

    public Long getSingerid() {
        return singerid;
    }

    public void setSingerid(Long singerid) {
        this.singerid = singerid;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername == null ? null : singername.trim();
    }

    public String getSingerhref() {
        return singerhref;
    }

    public void setSingerhref(String singerhref) {
        this.singerhref = singerhref == null ? null : singerhref.trim();
    }

    public String getSingerdesc() {
        return singerdesc;
    }

    public void setSingerdesc(String singerdesc) {
        this.singerdesc = singerdesc == null ? null : singerdesc.trim();
    }
}