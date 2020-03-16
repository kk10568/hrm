package com.hrm.company.controller;

import com.hrm.common.entity.Result;
import com.hrm.common.utils.IdWorker;
import com.hrm.company.server.DepartmentServer;
import com.hrm.company.server.impl.DepartmentServerImpl;
import com.hrm.model.company.entity.Department;
import com.hrm.model.company.entity.response.DeptListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-16 20:31
 **/
@CrossOrigin
@RestController
@RequestMapping("/company/department")
public class DepartmentController {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private DepartmentServerImpl departmentServer;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Result insert(Department recover) {
        int insert = departmentServer.insert(recover);
        if (insert > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable("id") String id) {
        int i = departmentServer.deleteById(id);
        if (i > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(Department recover) {
        int i = departmentServer.updateByPrimaryKeySelective(recover);
        if (i > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }

    @RequestMapping(value = "/findById{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id) {
        Department dept = departmentServer.findById(id);
        if (dept != null){
            return Result.SUCCESS(dept);
        }else {
            return Result.FAIL("未查询到结果");
        }
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Result findById() {
        List<Department> list = departmentServer.findAll("1");
        if (list.size()>0){
            DeptListResult deptListResult = new DeptListResult(list.get(0).getCompanyId(), list.get(0).getName(), list.get(0).getManager(), list);
            return Result.SUCCESS(deptListResult);
        }else {
            return Result.FAIL("未查询到结果");
        }
    }
}
