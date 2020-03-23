package com.hrm.system.controller;

import com.hrm.common.entity.Result;
import com.hrm.common.entity.ResultCode;
import com.hrm.common.utils.IdWorker;
import com.hrm.model.system.entity.Permission;
import com.hrm.system.service.impl.PermissionApiServiceImpl;
import com.hrm.system.service.impl.PermissionMenuServiceImpl;
import com.hrm.system.service.impl.PermissionPointServiceImpl;
import com.hrm.system.service.impl.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//1.解决跨域
@CrossOrigin
//2.声明restContoller
@RestController
//3.设置父路径
@RequestMapping(value = "/sys")
public class PermissionController {
    @Autowired
    private PermissionServiceImpl permissionService;
    @Autowired
    private PermissionApiServiceImpl permissionApiService;
    @Autowired
    private PermissionMenuServiceImpl permissionMenuService;
    @Autowired
    private PermissionPointServiceImpl permissionPointService;
    @Autowired
    private IdWorker idWorker;

    /**
     * 保存
     */
    @RequestMapping(value = "/permission", method = RequestMethod.POST)
    public Result insert(@RequestBody Permission recover) {
        //type=1时添加菜单
        //type=2时添加按钮
        //type=3添加Api
        recover.setId(idWorker.nextId() + "");
        System.out.println(recover);
        permissionService.insert(recover);
        if (recover.getType()==1) {
            permissionMenuService.insert(recover);
        }else if(recover.getType()==2){
            permissionPointService.insert(recover);
        }else {
            permissionApiService.insert(recover);
        }
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable(value = "id") String id, @RequestBody Permission recover) throws Exception {
        //构造id
        recover.setId(id);
        System.out.println(recover);
        permissionService.update(recover);
        //权限类型 1为菜单 2为功能 3为API
        if (recover.getType()==1) {
            permissionMenuService.update(recover);
        }else if(recover.getType()==2){
            permissionPointService.update(recover);
        }else {
            permissionApiService.update(recover);
        }
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    public Result findAll(String type, String pid, String enVisible) {
        //api要求type=0时查询菜单+按钮
        //type=1时查询菜单
        //type=2时查询按钮
        //type=3查询Api
        System.out.println(type);
        System.out.println(pid);
        System.out.println(enVisible);
        List<Permission> list = permissionService.findAll(type, pid, enVisible);
        return new Result(ResultCode.SUCCESS, list);
    }

    /**
     * 根据ID查询
     */
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id) {
        System.out.println(id);
        Permission permission = permissionService.findById(id);
        System.out.println("根据id查询结果：" + permission);
        return new Result(ResultCode.SUCCESS, permission);
    }


    /**
     * 根据id删除
     */
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value = "id") String id) {
        permissionService.delete(id);
        permissionPointService.deleteById(id);
        permissionMenuService.deleteById(id);
        permissionApiService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }
}
