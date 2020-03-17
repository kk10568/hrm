package com.hrm.system.service.impl;

import com.hrm.model.system.entity.User;
import com.hrm.system.mapper.UserMapper;
import com.hrm.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-17 18:01
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int deleteById(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int update(User record) {
        return userMapper.update(record);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> selectAllPage(int pageMin, int pageMax) {

        return userMapper.selectAllPage(pageMin, pageMax);
    }

    @Override
    public User selectById(String id) {
        return userMapper.selectById(id);
    }
}
