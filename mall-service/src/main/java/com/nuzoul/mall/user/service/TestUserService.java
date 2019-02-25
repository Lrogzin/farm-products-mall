package com.nuzoul.mall.user.service;

import com.nuzoul.mall.user.service.req.TestUserReq;
import com.nuzoul.mall.user.service.resp.TestUserResp;

/**
 * @Author: nuzoul
 * @Date: 2019/2/24 21:24
 */
public interface TestUserService {
    TestUserResp testAdd(TestUserReq req);
}
