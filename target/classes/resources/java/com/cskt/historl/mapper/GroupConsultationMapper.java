package com.cskt.historl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cskt.historl.entity.GroupConsultation;
import com.cskt.historl.vo.ApplyGroupConsultation;
import com.cskt.historl.vo.GroupList;
import com.cskt.historl.vo.UserName;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
  * @author: 朱晴晴
  * @date: 2021/2/4 15:36
  * @description GroupConsultationMapper
  */
@Mapper
public interface GroupConsultationMapper extends BaseMapper<GroupConsultation> {
    /**
     * 查询待分诊的数量
     * @return  返回待分诊的数量
     */
    Integer findWaitingNum();

    /**
     * 查询当日需要会诊的个数
     */
    Integer findHCount(String doctorId);

    /**
     * 会诊列表
     * @param doctorId
     * @return
     */
    List<GroupList> findHList(@Param("doctorId") String doctorId, @Param("sufferName") String sufferName);

    /**
     * 查询会诊单信息
     * @param doctorId
     * @return
     */
    ApplyGroupConsultation findHDanInfo(String doctorId);

    /**
     * 查询会诊单上医生的信息
     * @param phone
     * @return
     */
    UserName findUserNameInfo(String phone);


}