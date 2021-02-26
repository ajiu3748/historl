package com.cskt.historl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cskt.historl.entity.Referral;
import com.cskt.historl.vo.ApplyGroupConsultation;
import com.cskt.historl.vo.ApplyRefer;
import com.cskt.historl.vo.GroupList;
import com.cskt.historl.vo.UserName;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReferralMapper extends BaseMapper<Referral> {
    /**
     * 查询待分诊的数量
     * @return  返回待分诊的数量
     */
    Integer findCheckNum();

    /**
     * 查询当日需要转诊的个数
     */
    Integer findZCount(String doctorId);

    /**
     * 转诊列表
     * @param doctorId
     * @return
     */
    List<GroupList> findZList(@Param("doctorId") String doctorId, @Param("sufferName") String sufferName);

    /**
     * 查询转诊单信息
     * @param doctorId
     * @return
     */
     ApplyRefer findZDanInfo(String doctorId);

}