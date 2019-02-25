package com.nuzoul.mall.user.service;

import com.nuzoul.mall.user.service.req.MallUserLoginReq;
import com.nuzoul.mall.user.service.resp.MallUserLoginResp;

/**
 * @Author: nuzoul
 * @Date: 2019/2/25 16:00
 */
public interface MallUserService {
    MallUserLoginResp mallUserLogin(MallUserLoginReq req);
}
