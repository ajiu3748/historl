package com.cskt.historl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cskt.historl.entity.User;
import com.cskt.historl.vo.ApplyHName;
import com.cskt.historl.vo.Myself;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    Myself findMy(String userId);

    /**
     *查询用户的科室医院名
     */
    ApplyHName findInfoName(String userId);
}