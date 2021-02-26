package com.cskt.historl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cskt.historl.entity.ChattingRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ChattingRecordsMapper extends BaseMapper<ChattingRecords> {
       /**
     * 转诊聊天
     * @param id
     * @param doctorId
     * @return
     */
    List<ChattingRecords> findByRefer(@Param("id") String id, @Param("doctorId")String doctorId);

    /**
     * 会诊聊天
     * @param id
     * @param doctorId
     * @return
     */
    List<ChattingRecords> findByGroup(@Param("id") String id, @Param("doctorId")String doctorId);
}