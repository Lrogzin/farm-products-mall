package com.nuzoul.mall.user.dao;

import com.nuzoul.mall.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: nuzoul
 * @Date: 2019/2/25 15:34
 */
@Repository
public class UserDao {
    @Autowired
    UserMapper userMapper;

    public User selectByPrimaryKey(Long id){
        return userMapper.selectByPrimaryKey(id);
    }
}
