package com.nuzoul.mall.user.service.impl;

import com.nuzoul.mall.common.service.RedisService;
import com.nuzoul.mall.user.service.MallUserService;
import com.nuzoul.mall.user.service.req.MallUserLoginReq;
import com.nuzoul.mall.user.service.resp.MallUserLoginResp;

/**
 * @Author: nuzoul
 * @Date: 2019/2/25 16:09
 */
public class MallUserServiceImpl extends RedisService implements MallUserService {

    @Override
    public MallUserLoginResp mallUserLogin(MallUserLoginReq req) {
        return null;
    }

    @Override
    protected String getModle() {
        return "MallUserService";
    }
}
