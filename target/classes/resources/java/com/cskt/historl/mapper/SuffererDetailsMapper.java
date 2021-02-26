package com.cskt.historl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cskt.historl.entity.SuffererDetails;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SuffererDetailsMapper extends BaseMapper<SuffererDetails> {
    //根据会诊/转诊id
    SuffererDetails findToGroupId(String id);
}