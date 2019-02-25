package com.nuzoul.mall.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.nuzoul.mall.common.service.RespCode;
import com.nuzoul.mall.common.service.RespMsg;
import com.nuzoul.mall.user.dao.UserDao;
import com.nuzoul.mall.user.entity.User;
import com.nuzoul.mall.user.service.TestUserService;
import com.nuzoul.mall.user.service.req.TestUserReq;
import com.nuzoul.mall.user.service.resp.TestUserResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: nuzoul
 * @Date: 2019/2/24 21:26
 */
public class TestUserServiceImpl implements TestUserService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserDao userDao;

    @Override
    public TestUserResp testAdd(TestUserReq req) {
        logger.info(JSON.toJSONString(req));
        TestUserResp resp = new TestUserResp();
        resp.setCode(RespCode.SUCCESS);
        resp.setMessage(RespMsg.SELECT_SUCCESS);
        User user = userDao.selectByPrimaryKey(1L);
        resp.setTestResult("result is " + JSON.toJSONString(user));
        return resp;
    }
}
