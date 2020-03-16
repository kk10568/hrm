package com.hrm.company.server;

import com.hrm.company.mapper.DepartmentMapper;
import com.hrm.model.company.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-16 20:24
 **/
public interface DepartmentServer {
    int deleteById(String id);

    int insert(Department record);

    int insertSelective(Department record);

    Department findById(String id);

    List<Department> findAll(String companyId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

}
