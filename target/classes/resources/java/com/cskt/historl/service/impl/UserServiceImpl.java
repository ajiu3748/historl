package com.cskt.historl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cskt.historl.config.AutoLoginENUMUtil;
import com.cskt.historl.config.AutoLoginModel;
import com.cskt.historl.config.HttpUtil;
import com.cskt.historl.constants.ResultCodeEnum;
import com.cskt.historl.exception.KetaiException;
import com.cskt.historl.vo.ApplyHName;
import com.cskt.historl.vo.Myself;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cskt.historl.entity.User;
import com.cskt.historl.mapper.UserMapper;
import com.cskt.historl.service.UserService;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户的相关信息
     * @Param code：前端传的code
     */
    @Override
    public User wxPay(AutoLoginModel autoLoginModel, HttpServletRequest request) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("appid", AutoLoginENUMUtil.SHOP_APPID.getName());
        param.put("secret",AutoLoginENUMUtil.SHOP_SECRET.getName());
        param.put("js_code",autoLoginModel.getCode());
        param.put("grant_type","authorization_code");
        //获取用户openid，返回Json格式
        String result = HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session",param);
        JSONObject jsonObject = JSON.parseObject(result);//String 转JSONOBJ
        String openId = jsonObject.getString("openid");
        if (StringUtils.isEmpty(openId)) {
            throw new Exception("获取用户openid失败" + autoLoginModel.getCode());
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wx_openid",openId);
        queryWrapper.eq("is_delete",2);
        User sysUser = baseMapper.selectOne(queryWrapper);
        return sysUser;
    }

    /**获取微信的opeId
     * @Param code：前端传的code
     */
    @Override
    public String getOpenId(String code) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("appid", AutoLoginENUMUtil.SHOP_APPID.getName());
        param.put("secret",AutoLoginENUMUtil.SHOP_SECRET.getName());
        param.put("js_code",code);
        //获取用户openid，返回Json格式
        String result = HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session",param);
        JSONObject jsonObject = JSON.parseObject(result);//String 转JSONOBJ
        String openId = jsonObject.getString("openid");
        return openId;
    }

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    @Override
    public Myself findMy(String userId) {
        return baseMapper.findMy(userId);
    }

    /**
     * 查询用户的科室医院名
     * @param userId
     * @return
     */
    @Override
    public ApplyHName findInfoName(String userId) {
        return baseMapper.findInfoName(userId);
    }
}
