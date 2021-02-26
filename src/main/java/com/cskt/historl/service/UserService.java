package com.cskt.historl.service;

import com.cskt.historl.config.AutoLoginModel;
import com.cskt.historl.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cskt.historl.vo.ApplyHName;
import com.cskt.historl.vo.Myself;

import javax.servlet.http.HttpServletRequest;

public interface UserService extends IService<User>{
    public User wxPay(AutoLoginModel autoLoginModel, HttpServletRequest request) throws Exception;
    /* *
     * 获取微信的opeId
     * @Param code：前端传的code
     */
    public String getOpenId(String code) throws Exception;
    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    Myself findMy(String userId);
    ApplyHName findInfoName(String userId);
}
