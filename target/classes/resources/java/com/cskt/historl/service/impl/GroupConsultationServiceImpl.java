package com.cskt.historl.service.impl;

import com.cskt.historl.vo.ApplyGroupConsultation;
import com.cskt.historl.vo.GroupList;
import com.cskt.historl.vo.UserName;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cskt.historl.entity.GroupConsultation;
import com.cskt.historl.mapper.GroupConsultationMapper;
import com.cskt.historl.service.GroupConsultationService;

@Service
public class GroupConsultationServiceImpl extends ServiceImpl<GroupConsultationMapper, GroupConsultation> implements GroupConsultationService{
    @Resource
    private GroupConsultationMapper groupConsultationMapper;

    @Override
    /**
     * 查询待分诊的数量
     * @return  返回待分诊的数量
     */
    public Integer findWaitingNum(){
        return groupConsultationMapper.findWaitingNum();
    }

    /**
     * 查询当日需要转诊的个数
     * @param doctorId
     */
    @Override
    public Integer findGCount(String doctorId) {
        return groupConsultationMapper.findHCount(doctorId);
    }

    /**
     * 会诊列表
     * @param doctorId
     * @param sufferName
     * @return
     */
    @Override
    public List<GroupList> findHList(String doctorId, String sufferName) {
        return groupConsultationMapper.findHList(doctorId,sufferName);
    }

    /**
     * 查询会诊单信息
     *
     * @param doctorId
     * @return
     */
    @Override
    public ApplyGroupConsultation findHDanInfo(String doctorId) {
        return groupConsultationMapper.findHDanInfo(doctorId);
    }

    /**
     * 查询会诊单上医生的信息
     *
     * @param phone
     * @return
     */
    @Override
    public UserName findUserNameInfo(String phone) {
        return groupConsultationMapper.findUserNameInfo(phone);
    }


}
