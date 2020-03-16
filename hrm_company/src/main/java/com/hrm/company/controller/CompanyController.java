package com.hrm.company.controller;

import com.hrm.common.entity.Result;
import com.hrm.common.entity.ResultCode;
import com.hrm.company.server.impl.CompanyServerImpl;
import com.hrm.model.company.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-14 18:55
 **/
@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyController {
    @Autowired
    private CompanyServerImpl companyServer;

    @RequestMapping("/insert")
    public Result insertCompany() {
        Company company = new Company();
        company.setId("1");
        company.setName("达摩");
        company.setManagerId("admin");
        company.setState(1);
        company.setBalance((double)0);
        company.setCreateTime(new Date());
        int insert = companyServer.insert(company);
        if (insert > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }
    @RequestMapping("/delete")
    public Result delete(String id){
        int delete = companyServer.delete(id);
        if (delete>0){
            return Result.SUCCESS();
        }else {
            return Result.FAIL();
        }
    }
    @RequestMapping("/update")
    public Result update(){
        Company company = new Company();
        company.setId("1");
        company.setName("DAMO");
        int update = companyServer.update(company);
        if (update>0){
            return Result.SUCCESS();
        }else {
            return Result.FAIL();
        }
    }
    @GetMapping(value = "/findById{id}")
    public Result findById(@PathVariable("id") String id){
        Company byId = companyServer.findById(id);
        if (byId!=null){
            return Result.SUCCESS(byId);
        }else {
            return Result.FAIL();
        }
    }
    @RequestMapping("/findAll")
    public Result findAll(){
        return Result.SUCCESS(companyServer.findAll());
    }

}
