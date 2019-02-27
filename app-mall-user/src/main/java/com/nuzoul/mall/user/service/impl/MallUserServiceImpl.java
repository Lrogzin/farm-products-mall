package com.nuzoul.mall.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuzoul.mall.common.service.RedisService;
import com.nuzoul.mall.common.service.RespCode;
import com.nuzoul.mall.common.service.RespMsg;
import com.nuzoul.mall.user.service.MallUserService;
import com.nuzoul.mall.user.service.req.GeetestInitReq;
import com.nuzoul.mall.user.service.req.MallUserLoginReq;
import com.nuzoul.mall.user.service.resp.GeetestInitResp;
import com.nuzoul.mall.user.service.resp.MallUserLoginResp;
import com.nuzoul.mall.utils.GeetestLib;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: nuzoul
 * @Date: 2019/2/25 16:09
 */
public class MallUserServiceImpl extends RedisService implements MallUserService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public GeetestInitResp geetestInit(GeetestInitReq req) {
        GeetestInitResp resp = new GeetestInitResp();
        try {
            GeetestLib gtSdk = new GeetestLib();
            //自定义参数,可选择添加
            HashMap<String, String> param = new HashMap<String, String>(16);
            //进行验证预处理
            int gtServerStatus = gtSdk.preProcess(param);
            String resStr = "{}";
            String key = UUID.randomUUID().toString();
            this.cacheSet(key,gtServerStatus,360);
            resStr = gtSdk.getResponseStr();
            JSONObject jsonObject = JSONObject.parseObject(resStr);
            logger.info("resp=={}",JSONObject.toJSONString(jsonObject));
            if(jsonObject.containsKey("gt")){
                resp.setGt(jsonObject.getString("gt"));
                resp.setChallenge(jsonObject.getString("challenge"));
                resp.setSuccess(jsonObject.getInteger("success"));
                resp.setStatusKey(key);
                resp.setCode(RespCode.SUCCESS);
                resp.setMessage(RespMsg.SELECT_SUCCESS);
            }else{
                resp.setCode(RespCode.FAIL);
                resp.setMessage(RespMsg.SELECT_FAIL);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public MallUserLoginResp mallUserLogin(MallUserLoginReq req) {
        return null;
    }

    @Override
    protected String getModle() {
        return "MallUserService";
    }
}
