package com.hrm.system.mapper;


import com.hrm.model.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int count();

    int insert(User record);

    int deleteById(String id);

    int update(User record);

    List<User> selectAll(String companyId);

    List<User> selectAllPage(String companyId,int pageMin, int pageMax);

    User selectById(String id);


}