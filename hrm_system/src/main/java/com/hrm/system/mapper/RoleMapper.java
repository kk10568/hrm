package com.hrm.system.mapper;

import com.hrm.model.system.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-18 12:39
 **/
@Mapper
public interface RoleMapper {

    int insert(Role recover);

    int delete(String id);

    int update(Role recover);

    Role findById(String id);

    List<Role> findAll(String companyId);

    List<Role> findAllPage(String companyId, int minPage, int maxPage);

    int count(String companyId);
}
