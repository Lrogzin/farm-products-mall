package com.nuzoul.common.service;

import java.util.HashMap;

/**
 * @Author: nuzoul
 * @Date: 2019/2/9 18:40
 */
public class BaseMapResp extends HashMap<String, Object> {

    public BaseMapResp() {
        this.put("code", RespCode.FAIL);
        this.put("message", RespMsg.SYSTEM_ERROR);
    }

    public void setCode(int code) {
        this.put("code", code);
    }

    public void setMessage(String message) {
        this.put("message", message);
    }

    public int getCode() {
        return (int) this.get("code");
    }

    public String getMessage() {
        return (String) this.get("message");
    }
}
