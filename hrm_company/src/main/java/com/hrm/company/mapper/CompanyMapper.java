package com.hrm.company.mapper;

import com.hrm.model.company.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyMapper {
    public int insert(Company company);

    public int deleteById(String id);

    public int update(Company company);

    public Company findById(String id);

    public List<Company> findAll();


}
