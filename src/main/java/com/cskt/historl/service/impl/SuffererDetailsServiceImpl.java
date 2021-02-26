package com.cskt.historl.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cskt.historl.mapper.SuffererDetailsMapper;
import com.cskt.historl.entity.SuffererDetails;
import com.cskt.historl.service.SuffererDetailsService;

@Service
public class SuffererDetailsServiceImpl extends ServiceImpl<SuffererDetailsMapper, SuffererDetails> implements SuffererDetailsService{

    @Override
    public SuffererDetails findToGroupId(String id) {
        return baseMapper.findToGroupId(id);
    }
}
