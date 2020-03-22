package com.hrm.company.controller;

import com.hrm.common.controller.BaseController;
import com.hrm.common.entity.Result;
import com.hrm.common.utils.IdWorker;
import com.hrm.company.service.impl.CompanyServiceImpl;
import com.hrm.company.service.impl.DepartmentServiceImpl;
import com.hrm.model.company.entity.Company;
import com.hrm.model.company.entity.Department;
import com.hrm.model.company.entity.response.DeptListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-16 20:31
 **/
@CrossOrigin
@RestController
@RequestMapping("/company/department")
public class DepartmentController extends BaseController {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private CompanyServiceImpl companyService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Result insert(@RequestBody Department recover) {
        recover.setCompanyId(companyId);
        //或者使用String.valueOf(idWorker.nextId())
        recover.setId(idWorker.nextId() + "");
        recover.setCreateTime(new Date());
        int insert = departmentService.insert(recover);
        if (insert > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable("id") String id) {
        int i = departmentService.deleteById(id);
        if (i > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }

    @RequestMapping(value = "/update{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable("id") String id, @RequestBody Department recover) {
        recover.setId(id);
        int i = departmentService.updateByPrimaryKeySelective(recover);
        if (i > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }

    @RequestMapping(value = "/findById{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id) {
        Department dept = departmentService.findById(id);
        if (dept != null) {
            return Result.SUCCESS(dept);
        } else {
            return Result.FAIL("未查询到结果");
        }
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Result findById() {
        List<Department> list = departmentService.findAll(companyId);
        if (list.size() > 0) {
            //根据公司查询到公司对象Company放入DeptListResult构造
            Company company = companyService.findById(companyId);
            DeptListResult deptListResult = new DeptListResult(company, list);
            return Result.SUCCESS(deptListResult);
        } else {
            return Result.FAIL("未查询到结果");
        }
    }
}
