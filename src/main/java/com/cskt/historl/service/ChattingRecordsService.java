package com.cskt.historl.service;

import com.cskt.historl.entity.ChattingRecords;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChattingRecordsService extends IService<ChattingRecords>{
    /**
     * 转诊聊天
     * @param id
     * @param doctorId
     * @return
     */
    List<ChattingRecords> findByRefer(String id,String doctorId);

    /**
     * 会诊聊天
     * @param id
     * @param doctorId
     * @return
     */
    List<ChattingRecords> findByGroup(String id,String doctorId);


}
