package com.cskt.historl.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cskt.historl.mapper.ReferralTypeMapper;
import com.cskt.historl.entity.ReferralType;
import com.cskt.historl.service.ReferralTypeService;

@Service
public class ReferralTypeServiceImpl extends ServiceImpl<ReferralTypeMapper, ReferralType> implements ReferralTypeService{

}
