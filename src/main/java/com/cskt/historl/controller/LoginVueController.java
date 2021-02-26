package com.cskt.historl.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cskt.historl.config.AutoLoginModel;
import com.cskt.historl.constants.ResultCodeEnum;
import com.cskt.historl.entity.User;
import com.cskt.historl.service.UserService;
import com.cskt.historl.util.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 登陆接口
 * @author: Mr.阿九
 * @createTime: 2021-02-20 14:54
 **/
@RestController
@RequestMapping(value = "/login")
public class LoginVueController {

    @Autowired
    private UserService userService;

    /**
     * 根据小程序传的参数进行自动登录， 并返回该用户的信息，小程序以作保留
     * @param jsonObject
     * @param request
     * @return
     * @throws Exception
     */
    @ApiOperation("自动登录")
    @RequestMapping(value = "/appAutoLogin", method = RequestMethod.POST)
    public Result<User> appAutoLogin(@RequestBody JSONObject jsonObject, HttpServletRequest request)throws Exception{
        Result<User> result=new Result<>();
        String code = jsonObject.get("code").toString();
        AutoLoginModel autoLoginModel = new AutoLoginModel();
        autoLoginModel.setCode(code);
        User sysUser = userService.wxPay(autoLoginModel,request);
        result.setResult(sysUser);
        return result;
    }

    @ApiOperation("登录接口")
    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public Result<User> loginIn(@RequestBody JSONObject jsonObject){
        Result<User> result=new Result<>();
        String phone = jsonObject.get("userPhone").toString();
        String pwd = jsonObject.get("loginPassword").toString();
        String code = jsonObject.get("code").toString();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserPhone,phone);
        queryWrapper.eq(User::getLoginPassword,pwd);
        queryWrapper.eq(User::getIsDelete,2);
        User sysUser = userService.getOne(queryWrapper);
        //获取openid
        String openid = "";
        try {
            openid = userService.getOpenId(code);
        }catch (Exception e){
            e.printStackTrace();
        }
        sysUser.setWxOpenid(openid);
        if(userService.updateById(sysUser)){
            result.setResult(sysUser);
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }
}
