package com.nuzoul.user.service.resp;

import com.nuzoul.common.service.BaseResp;

/**
 * @Author: nuzoul
 * @Date: 2019/2/25 16:06
 */
public class MallUserLoginResp extends BaseResp {

    private Integer userId;
    private String token;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
