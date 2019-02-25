package com.nuzoul.mall.controller;

import com.nuzoul.mall.user.service.MallUserService;
import com.nuzoul.mall.user.service.req.MallUserLoginReq;
import com.nuzoul.mall.user.service.resp.MallUserLoginResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: nuzoul
 * @Date: 2019/2/25 16:07
 */
@Controller
@RequestMapping("/member")
public class MallUserController {

    @Autowired
    MallUserService mallUserService;

    @RequestMapping("/login")
    public ResponseEntity<MallUserLoginResp> login(@RequestBody MallUserLoginReq req){
        MallUserLoginResp resp = new MallUserLoginResp();
        try{
            resp = mallUserService.mallUserLogin(req);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(resp);
    }
}
