package com.cskt.historl.service;

import com.cskt.historl.entity.SuffererDetails;
import com.baomidou.mybatisplus.extension.service.IService;

public interface SuffererDetailsService extends IService<SuffererDetails>{
    //根据会诊/转诊id
    SuffererDetails findToGroupId(String id);

}
