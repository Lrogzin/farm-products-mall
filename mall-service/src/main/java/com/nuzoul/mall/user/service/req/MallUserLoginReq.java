package com.nuzoul.mall.user.service.req;

import com.nuzoul.mall.common.service.BaseReq;

/**
 * @Author: nuzoul
 * @Date: 2019/2/25 16:05
 */
public class MallUserLoginReq extends BaseReq {

    private String userName;

    private String userPwd;

    private String challenge;

    private String validate;

    private String seccode;

    private String statusKey;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public String getSeccode() {
        return seccode;
    }

    public void setSeccode(String seccode) {
        this.seccode = seccode;
    }

    public String getStatusKey() {
        return statusKey;
    }

    public void setStatusKey(String statusKey) {
        this.statusKey = statusKey;
    }
}
