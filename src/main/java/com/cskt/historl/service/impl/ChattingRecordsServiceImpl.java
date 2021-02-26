package com.cskt.historl.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cskt.historl.mapper.ChattingRecordsMapper;
import com.cskt.historl.entity.ChattingRecords;
import com.cskt.historl.service.ChattingRecordsService;

@Service
public class ChattingRecordsServiceImpl extends ServiceImpl<ChattingRecordsMapper, ChattingRecords> implements ChattingRecordsService{

    /**
     * 转诊聊天
     *
     * @param id
     * @param doctorId
     * @return
     */
    @Override
    public List<ChattingRecords> findByRefer(String id, String doctorId) {
        return baseMapper.findByRefer(id, doctorId);
    }

    /**
     * 会诊聊天
     *
     * @param id
     * @param doctorId
     * @return
     */
    @Override
    public List<ChattingRecords> findByGroup(String id, String doctorId) {
        return baseMapper.findByGroup(id, doctorId);
    }
}
