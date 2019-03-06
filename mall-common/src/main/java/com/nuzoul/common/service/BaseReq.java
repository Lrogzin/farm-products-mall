package com.nuzoul.common.service;

import com.google.common.base.Strings;
import com.nuzoul.common.anotation.VaildEmpty;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @Author: nuzoul
 * @Date: 2019/2/9 18:40
 */
public class BaseReq implements Serializable {

    private String _errMsg;

    private String _userId;

    private String _userIp;

    private Long _timeStamp;

    public String get_errMsg() {
        return _errMsg;
    }

    public void set_errMsg(String _errMsg) {
        this._errMsg = _errMsg;
    }

    public String get_userId() {
        return _userId;
    }

    public void set_userId(String _userId) {
        this._userId = _userId;
    }

    public String get_userIp() {
        return _userIp;
    }

    public void set_userIp(String _userIp) {
        this._userIp = _userIp;
    }

    public Long get_timeStamp() {
        return _timeStamp;
    }

    public void set_timeStamp(Long _timeStamp) {
        this._timeStamp = _timeStamp;
    }

    private boolean checkField(Field[] fields) {
        for (Field f : fields) {
            f.setAccessible(true);
            VaildEmpty vaildEmpty = f.getAnnotation(VaildEmpty.class);
            try {
                if (vaildEmpty != null) {
                    if (f.getType() == String.class) {
                        String value = (String) f.get(this);
                        if (Strings.isNullOrEmpty(value)) {
                            this._errMsg = vaildEmpty.message();
                            return true;
                        }
                    }
                    if (f.getType() == Integer.class) {
                        Integer value = (Integer) f.get(this);
                        if (value == null) {
                            this._errMsg = vaildEmpty.message();
                            return true;
                        }
                    }
                    if (f.getType() == Long.class) {
                        Long value = (Long) f.get(this);
                        if (value == null) {
                            this._errMsg = vaildEmpty.message();
                            return true;
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean isEmpty() {
        Field[] fields = this.getClass().getDeclaredFields();
        Field[] parentFields = this.getClass().getSuperclass().getDeclaredFields();
        return this.checkField(parentFields) || this.checkField(fields);
    }
}
