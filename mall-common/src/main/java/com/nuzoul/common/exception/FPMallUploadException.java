package com.nuzoul.common.exception;

/**
 * @author Nuzoul
 */
public class FPMallUploadException extends RuntimeException {

    private String msg;

    public FPMallUploadException(String msg){
        super(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
