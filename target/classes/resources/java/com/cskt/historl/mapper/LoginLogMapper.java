package com.cskt.historl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cskt.historl.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;

/**
  * @author: 朱晴晴
  * @date: 2021/2/4 15:36
  * @description LoginLogMapper
  */
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {
}