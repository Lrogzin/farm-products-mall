package com.nuzoul.mall.user.service;

import com.nuzoul.mall.user.service.req.GeetestInitReq;
import com.nuzoul.mall.user.service.req.MallUserLoginReq;
import com.nuzoul.mall.user.service.resp.GeetestInitResp;
import com.nuzoul.mall.user.service.resp.MallUserLoginResp;

/**
 * @Author: nuzoul
 * @Date: 2019/2/25 16:00
 */
public interface MallUserService {

    /**
     * 极验初始化
     * @param req
     * @return
     */
    GeetestInitResp geetestInit(GeetestInitReq req);

    MallUserLoginResp mallUserLogin(MallUserLoginReq req);
}
