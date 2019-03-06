package com.nuzoul.common.exception;

/**
 * @author Exrick
 * @date 2017/8/24
 */
public class FPMallException extends RuntimeException {

    private String msg;

    public FPMallException(String msg){
        super(msg);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
