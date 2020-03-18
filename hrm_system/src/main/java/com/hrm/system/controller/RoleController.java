package com.hrm.system.controller;

import com.hrm.common.controller.BaseController;
import com.hrm.common.entity.PageResult;
import com.hrm.common.entity.Result;
import com.hrm.common.entity.ResultCode;
import com.hrm.common.utils.IdWorker;
import com.hrm.model.system.entity.Role;
import com.hrm.system.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleResult;
import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-18 13:31
 **/
@CrossOrigin
@RestController
@RequestMapping("/sys")
public class RoleController extends BaseController {
    @Autowired
    private RoleServiceImpl roleService;
    @Autowired
    private IdWorker idWorker;

   /* @RequestMapping(value = "/role/assignPrem", method = RequestMethod.PUT)
    public Result update(@RequestBody Role recover) {
        recover.setCompanyId(companyId);
        int update = roleService.update(recover);
        if (update>0){
            return Result.SUCCESS();
        }else {
            return Result.FAIL("添加信息失败");
        }
    }*/


    //添加角色
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public Result insert(@RequestBody Role role) {
        role.setId(idWorker.nextId() + "");
        role.setCompanyId(companyId);
        int insert = roleService.insert(role);
        if (insert > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL("添加信息失败");
        }

    }

    //更新角色
    @RequestMapping(value = "/role/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable(name = "id") String id, @RequestBody Role role) {
        int update = roleService.update(role);
        if (update > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL("添加信息失败");
        }
    }

    //删除角色
    @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable(name = "id") String id) throws Exception {
        int delete = roleService.delete(id);
        if (delete > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL("添加信息失败");
        }
    }

    /**
     * 根据ID获取角色信息
     */
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(name = "id") String id) throws Exception {
        Role role = roleService.findById(id);
        return new Result(ResultCode.SUCCESS, role);
    }

    /**
     * 分页查询角色
     */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public Result findByPage(int page, int pagesize) {
        List<Role> allPage = roleService.findAllPage(companyId, (page - 1) * pagesize, pagesize * page);
        int count = roleService.count(companyId);
        PageResult<Role> rolePageResult = new PageResult<Role>(allPage);
        rolePageResult.setTotal(Long.valueOf(count));
        return new Result(ResultCode.SUCCESS, rolePageResult);
    }

    @RequestMapping(value = "/role/list", method = RequestMethod.GET)
    public Result findAll() throws Exception {
        List<Role> roleList = roleService.findAll(companyId);
        return new Result(ResultCode.SUCCESS, roleList);
    }
}
