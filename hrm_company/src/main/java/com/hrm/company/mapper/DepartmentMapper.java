package com.hrm.company.mapper;

import com.hrm.model.company.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    int deleteById(String id);

    int insert(Department record);

    int insertSelective(Department record);

    Department findById(String id);

    List<Department> findAll(String companyId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}