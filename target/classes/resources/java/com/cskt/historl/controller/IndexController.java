package com.cskt.historl.controller;

import com.cskt.historl.entity.SuffererDetails;
import com.cskt.historl.service.GroupConsultationService;
import com.cskt.historl.service.ReferralService;
import com.cskt.historl.util.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 首页个数接口
 * @author: Mr.阿九
 * @createTime: 2021-02-22 10:02
 **/
@RestController
public class IndexController {
    @Resource
    private GroupConsultationService groupConsultationService;
    @Resource
    private ReferralService referralService;

    @ApiOperation("查询当日会诊个数-信息")
    @RequestMapping(value = "/findGroupNum", method = RequestMethod.GET)
    public Result<Integer> findGroupNum(String doctorId){
        Result<Integer> result=new Result<>();
        result.setResult(groupConsultationService.findGCount(doctorId));
        return result;
    }

    @ApiOperation("查询当日转诊个数-信息")
    @RequestMapping(value = "/findReferNum", method = RequestMethod.GET)
    public Result<Integer> findReferNum(String doctorId){
        Result<Integer> result=new Result<>();
        result.setResult(referralService.findZCount(doctorId));
        return result;
    }


}
