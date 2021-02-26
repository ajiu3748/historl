package com.cskt.historl.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cskt.historl.entity.LoginLog;
import com.cskt.historl.mapper.LoginLogMapper;
import com.cskt.historl.service.LoginLogService;

@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService{

}
