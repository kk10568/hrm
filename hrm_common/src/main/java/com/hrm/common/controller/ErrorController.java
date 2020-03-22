package com.hrm.common.controller;

import com.hrm.common.entity.Result;
import com.hrm.common.entity.ResultCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-22 15:22
 **/
@CrossOrigin
@RestController
public class ErrorController {
    //公共错误跳转
    @RequestMapping(value="autherror")
    public Result autherror(int code) {
        return code ==1?new Result(ResultCode.UNAUTHENTICATED):new Result(ResultCode.UNAUTHORISE);
    }
}
