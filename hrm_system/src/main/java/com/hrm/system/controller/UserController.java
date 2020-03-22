package com.hrm.system.controller;

import com.hrm.common.controller.BaseController;
import com.hrm.common.entity.PageResult;
import com.hrm.common.entity.Result;
import com.hrm.common.entity.ResultCode;
import com.hrm.common.utils.IdWorker;
import com.hrm.model.system.entity.User;
import com.hrm.model.system.entity.result.ProfileResult;
import com.hrm.system.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
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
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Map<String,String> map) {
        String mobile = map.get("mobile");
        String password = map.get("password");
        System.out.println(mobile);
        System.out.println(password);
        //md5加密
        password = new Md5Hash(password, mobile, 3).toString();
        UsernamePasswordToken upToken = new UsernamePasswordToken(mobile, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(upToken);
            String sessionId = subject.getSession().getId().toString();
            //前端设置的如果登录成功会将返回值作为token存入requestHeader
            //前端的代码规则为Authorization的头信息主体为Bearer +头信息
            System.out.println("sessionId="+sessionId);
            PrincipalCollection principals = subject.getPrincipals();
            System.out.println("principals="+principals);
            //2.获取安全数据
            ProfileResult result = (ProfileResult) principals.getPrimaryPrincipal();
            System.out.println("getCompany="+result.getCompany());
            return Result.SUCCESS(sessionId);
        } catch (Exception e) {
            return Result.FAIL("用户或密码错误");
        }
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public Result profile(HttpServletRequest request) {
        //获取session中的安全数据
        Subject subject = SecurityUtils.getSubject();
        //1.subject获取所有的安全数据集合
        PrincipalCollection principals = subject.getPrincipals();
        //2.获取安全数据
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        System.out.println(primaryPrincipal);
        ProfileResult profileResult = new ProfileResult();
        ProfileResult primaryPrincipal1 = (ProfileResult) primaryPrincipal;
       /* try {
            BeanUtils.copyProperties(profileResult,primaryPrincipal);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/
        return new Result(ResultCode.SUCCESS, primaryPrincipal);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result logout(HttpServletRequest request) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/user/assignRoles", method = RequestMethod.PUT)
    public Result save(@RequestParam("id") String id, @RequestParam("roleIds") List<String> roleIds) {
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

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable("id") String id, @RequestBody User record) {
        record.setId(id);
        String newPassword = new Md5Hash(record.getPassword(), record.getMobile()).toString();
        record.setPassword(newPassword);
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
        List<User> users = userService.selectAllPage(companyId, (page - 1) * size, size);
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
        //设置初始密码(123456)
        //md5三次加密
        record.setPassword(new Md5Hash("123456", record.getUsername(), 3).toString());
        record.setLevel("user");
        int i = userService.insert(record);
        if (i > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }

}
