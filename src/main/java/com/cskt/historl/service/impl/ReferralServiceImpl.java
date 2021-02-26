package com.cskt.historl.service.impl;

import com.cskt.historl.vo.ApplyGroupConsultation;
import com.cskt.historl.vo.ApplyRefer;
import com.cskt.historl.vo.GroupList;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cskt.historl.mapper.ReferralMapper;
import com.cskt.historl.entity.Referral;
import com.cskt.historl.service.ReferralService;
@Service
public class ReferralServiceImpl extends ServiceImpl<ReferralMapper, Referral> implements ReferralService{
    @Resource
    private ReferralMapper referralMapper;

    /**
     * 查询待分诊的数量
     * @return  返回待分诊的数量
     */
    @Override
    public Integer findCheckNum() {
        return referralMapper.findCheckNum();
    }

    /**
     * 查询当日需要转诊的个数
     *
     * @param doctorId
     * @return
     */
    @Override
    public Integer findZCount(String doctorId) {
        return referralMapper.findZCount(doctorId);
    }

    /**
     * 转诊列表
     *
     * @param doctorId
     * @param sufferName
     * @return
     */
    @Override
    public List<GroupList> findZList(String doctorId, String sufferName) {
        return referralMapper.findZList(doctorId, sufferName);
    }

    /**
     * 查询转诊单信息
     *
     * @param doctorId
     * @return
     */
    @Override
    public ApplyRefer findZDanInfo(String doctorId) {
        return referralMapper.findZDanInfo(doctorId);
    }
}
