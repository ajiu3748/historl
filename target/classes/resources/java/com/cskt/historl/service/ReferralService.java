package com.cskt.historl.service;

import com.cskt.historl.entity.Referral;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cskt.historl.vo.ApplyGroupConsultation;
import com.cskt.historl.vo.ApplyRefer;
import com.cskt.historl.vo.GroupList;

import java.util.List;

public interface ReferralService extends IService<Referral>{
        /**
         * 查询待分诊的数量
         * @return  返回待分诊的数量
         */
        Integer findCheckNum();

        /**
         * 查询当日需要转诊的个数
         * @param doctorId
         * @return
         */
        Integer findZCount(String doctorId);

        /**
         * 转诊列表
         * @param doctorId
         * @return
         */
        List<GroupList> findZList(String doctorId, String sufferName);

        /**
         * 查询转诊单信息
         * @param doctorId
         * @return
         */
        ApplyRefer findZDanInfo(String doctorId);
}
