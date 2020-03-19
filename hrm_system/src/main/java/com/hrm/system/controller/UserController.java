package com.hrm.system.controller;

import com.hrm.common.controller.BaseController;
import com.hrm.common.entity.PageResult;
import com.hrm.common.entity.Result;
import com.hrm.common.entity.ResultCode;
import com.hrm.common.utils.IdWorker;
import com.hrm.model.system.entity.User;
import com.hrm.system.service.impl.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-17 18:03
 **/
@CrossOrigin
@RestController
@RequestMapping("/sys")
public class UserController extends BaseController {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private UserServiceImpl userService;

    /**
     * 分配角色
     */
    @RequestMapping(value = "/user/assignRoles", method = RequestMethod.PUT)
    public Result save(@RequestParam("id") String id,@RequestParam("roleIds")List<String> roleIds) {
       /* //1.获取被分配的用户id
        String userId = (String) map.get("id");
        //2.获取到角色的id列表
        List<String> roleIds = (List<String>) map.get("roleIds");
        //3.调用service完成角色分配*/
        System.out.println(id);
        System.out.println(roleIds);
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("id") String id) {
        int i = userService.deleteById(id);
        if (i > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public Result update(@PathVariable("id") String id, @RequestBody User record) {
        record.setId(id);
        int i = userService.update(record);
        if (i > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Result selectById(String id) {
        User user = userService.selectById(id);
        if (user != null) {
            return Result.SUCCESS(user);
        } else {
            return Result.FAIL();
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Result selectAll(int page, int size) {
        List<User> users = userService.selectAllPage(companyId,(page - 1) * size, size);
        if (users != null || users.size() > 0) {
            PageResult<User> userPageResult = new PageResult<User>(users);
            userPageResult.setTotal(Long.valueOf(userService.count()));
            return Result.SUCCESS(userPageResult);
        } else {
            return Result.FAIL();
        }

    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Result insert(@RequestBody User record) {
        //设置主键id
        record.setId(idWorker.nextId() + "");
        //设置初始密码
        record.setPassword("123456");
        int i = userService.insert(record);
        if (i > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }
}
