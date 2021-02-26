package com.cskt.historl.controller;

import com.cskt.historl.service.UserService;
import com.cskt.historl.util.Result;
import com.cskt.historl.vo.Myself;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @description: 用户操作行为接口
 * @author: Mr.阿九
 * @createTime: 2021-02-20 16:41
 **/
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("用户信息-我")
    @RequestMapping(value = "/selectMy", method = RequestMethod.GET)
    public Result<Myself> selectMy(String userId){
        Result<Myself> result=new Result<>();
        result.setResult(userService.findMy(userId));
        return result;
    }



}
