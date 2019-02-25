package com.nuzoul.mall.user.service.req;

import com.nuzoul.mall.common.service.BaseReq;

/**
 * @Author: nuzoul
 * @Date: 2019/2/24 22:20
 */
public class TestUserReq extends BaseReq {
    private Integer a;
    private Integer b;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }
}
