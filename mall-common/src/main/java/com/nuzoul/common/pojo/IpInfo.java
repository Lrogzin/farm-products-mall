package com.nuzoul.common.pojo;

import java.io.Serializable;

/**
 * @author Nuzoul
 */
public class IpInfo implements Serializable{

    String url;

    String p;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }
}
