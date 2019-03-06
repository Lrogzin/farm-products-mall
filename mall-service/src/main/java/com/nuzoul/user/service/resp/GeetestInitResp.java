package com.nuzoul.user.service.resp;

import com.nuzoul.common.service.BaseResp;

/**
 * @Author: nuzoul
 * @Date: 2019/2/27 0:38
 */
public class GeetestInitResp extends BaseResp {

    private Integer success;

    private String challenge;

    private String gt;

    private String statusKey;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getStatusKey() {
        return statusKey;
    }

    public void setStatusKey(String statusKey) {
        this.statusKey = statusKey;
    }
}
