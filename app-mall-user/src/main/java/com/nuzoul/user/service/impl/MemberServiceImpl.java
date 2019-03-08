package com.nuzoul.user.service.impl;

import com.google.gson.Gson;
import com.nuzoul.common.constant.Common;
import com.nuzoul.common.exception.FPMallException;
import com.nuzoul.common.jedis.JedisClient;
import com.nuzoul.common.utils.QiniuUtil;
import com.nuzoul.dto.front.Member;
import com.nuzoul.mapper.TbMemberMapper;
import com.nuzoul.pojo.TbMember;
import com.nuzoul.user.service.LoginService;
import com.nuzoul.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Nuzoul
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private LoginService loginService;
    @Autowired
    private TbMemberMapper tbMemberMapper;
    @Autowired
    private JedisClient jedisClient;
    private Integer SESSION_EXPIRE = Common.SESSION_EXPIRE;

    @Override
    public String imageUpload(Long userId,String token,String imgData) {

        //过滤data:URL
        String base64= QiniuUtil.base64Data(imgData);
        String imgPath= QiniuUtil.qiniuBase64Upload(base64);

        TbMember tbMember=tbMemberMapper.selectByPrimaryKey(userId);
        if(tbMember==null){
            throw new FPMallException("通过id获取用户失败");
        }
        tbMember.setFile(imgPath);
        if(tbMemberMapper.updateByPrimaryKey(tbMember)!=1){
            throw new FPMallException("更新用户头像失败");
        }

        //更新缓存
        Member member=loginService.getUserByToken(token);
        member.setFile(imgPath);
        jedisClient.set("SESSION:" + token, new Gson().toJson(member));
        return imgPath;
    }
}
