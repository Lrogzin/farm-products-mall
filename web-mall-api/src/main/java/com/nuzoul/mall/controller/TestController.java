package com.nuzoul.mall.controller;

import com.nuzoul.mall.user.service.TestUserService;
import com.nuzoul.mall.user.service.req.TestUserReq;
import com.nuzoul.mall.user.service.resp.TestUserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: nuzoul
 * @Date: 2019/2/24 21:28
 */
@Controller
@RequestMapping("/testc")
public class TestController {
    @Autowired
    TestUserService testUserService;

    @ResponseBody
    @RequestMapping("/test")
    public ResponseEntity<TestUserResp> test(@RequestBody TestUserReq req) {
        TestUserResp resp = new TestUserResp();
        try {
            resp =
                    testUserService.testAdd(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(resp);
    }

    @ResponseBody
    @RequestMapping("/test2")
    public String test2(){
        return "hello";
    }
}
