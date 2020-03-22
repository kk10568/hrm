package com.hrm.company.controller;

import com.hrm.common.controller.BaseController;
import com.hrm.common.entity.Result;
import com.hrm.common.utils.IdWorker;
import com.hrm.company.service.impl.CompanyServiceImpl;
import com.hrm.model.company.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-14 18:55
 **/
@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController extends BaseController {
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private IdWorker idWorker;
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Result insertCompany(@RequestBody Company company) {
        company.setId(idWorker.nextId()+"");
        int insert = companyService.insert(company);
        if (insert > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Result delete(String id){
        int delete = companyService.delete(id);
        if (delete>0){
            return Result.SUCCESS();
        }else {
            return Result.FAIL();
        }
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Result update(@RequestBody Company company){
        int update = companyService.update(company);
        if (update>0){
            return Result.SUCCESS();
        }else {
            return Result.FAIL();
        }
    }
    @GetMapping(value = "/findById{id}")
    public Result findById(@PathVariable("id") String id){
        Company byId = companyService.findById(id);
        if (byId!=null){
            return Result.SUCCESS(byId);
        }else {
            return Result.FAIL();
        }
    }
    @RequestMapping("/findAll")
    public Result findAll(){
        return Result.SUCCESS(companyService.findAll());
    }

}
