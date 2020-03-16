package com.hrm.company.server;

import com.hrm.model.company.entity.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyServer {
    public int insert(Company company);
    public int delete(String id);
    public int update(Company company);
    public Company findById(String id);
    public List<Company> findAll();
}
