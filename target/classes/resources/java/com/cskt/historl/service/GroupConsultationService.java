package com.cskt.historl.service;

import com.cskt.historl.entity.GroupConsultation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cskt.historl.vo.ApplyGroupConsultation;
import com.cskt.historl.vo.GroupList;
import com.cskt.historl.vo.UserName;

import java.util.List;

public interface GroupConsultationService extends IService<GroupConsultation>{
        /**
         * 查询待分诊的数量
         * @return  返回待分诊的数量
         */
        Integer findWaitingNum();

        /**
         * 查询当日需要转诊的个数
         */
        Integer findGCount(String doctorId);

        /**
         * 会诊列表
         * @param doctorId
         * @return
         */
        List<GroupList> findHList(String doctorId,String sufferName);

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
