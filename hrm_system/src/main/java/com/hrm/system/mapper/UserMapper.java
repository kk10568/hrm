package com.hrm.system.mapper;


import com.hrm.model.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User record);

    int deleteById(String id);

    int update(User record);

    List<User> selectAll();

    List<User> selectAllPage(int pageMin, int pageMax);

    User selectById(String id);
}