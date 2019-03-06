package com.nuzoul.common.service;

import java.io.Serializable;

/**
 * @Author: nuzoul
 * @Date: 2019/2/9 18:40
 */
public class BaseResp implements Serializable {

    private int code = RespCode.FAIL;

    private String message = "fail";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
