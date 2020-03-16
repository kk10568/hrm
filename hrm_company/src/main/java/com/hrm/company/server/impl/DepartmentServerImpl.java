package com.hrm.company.server.impl;

import com.hrm.company.mapper.DepartmentMapper;
import com.hrm.company.server.DepartmentServer;
import com.hrm.model.company.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-16 20:28
 **/
@Service
public class DepartmentServerImpl implements DepartmentServer {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public int deleteById(String id) {
        return departmentMapper.deleteById(id);
    }

    @Override
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    @Override
    public Department findById(String id) {
        return departmentMapper.findById(id);
    }

    @Override
    public List<Department> findAll(String companyId) {
        return departmentMapper.findAll(companyId);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }
}
