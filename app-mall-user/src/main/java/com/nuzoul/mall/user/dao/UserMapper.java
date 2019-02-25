package com.nuzoul.mall.user.dao;

import com.nuzoul.mall.mybatis.BaseMapper;
import com.nuzoul.mall.user.entity.User;

public interface UserMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}