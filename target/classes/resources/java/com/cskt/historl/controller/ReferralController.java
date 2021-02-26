package com.cskt.historl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cskt.historl.entity.*;
import com.cskt.historl.service.ChattingRecordsService;
import com.cskt.historl.service.ReferralService;
import com.cskt.historl.service.ReferralTypeService;
import com.cskt.historl.service.SuffererDetailsService;
import com.cskt.historl.util.Result;
import com.cskt.historl.vo.ApplyGroupConsultation;
import com.cskt.historl.vo.ApplyRefer;
import com.cskt.historl.vo.GroupList;
import com.cskt.historl.vo.UserName;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description: 转诊接口
 * @author: Mr.阿九
 * @createTime: 2021-02-20 19:17
 **/
@RestController
@RequestMapping(value = "/referral")
public class ReferralController {
    @Resource
    private ReferralService referralService;
    @Resource
    private SuffererDetailsService suffererDetailsService;
    @Resource
    private ReferralTypeService referralTypeService;
    @Resource
    private ChattingRecordsService chattingRecordsService;

    @ApiOperation("查询转诊列表-信息")
    @RequestMapping(value = "/findReferList", method = RequestMethod.GET)
    public Result<List<GroupList>> findReferList(String doctorId,String sufferName){
        Result<List<GroupList>> result=new Result<>();
        result.setResult(referralService.findZList(doctorId, sufferName));
        return result;
    }

    @ApiOperation("申请转诊-预约")
    @RequestMapping(value = "/addRefer", method = RequestMethod.GET)
    public Result<Referral> addRefer(ApplyRefer apply){
        Result<Referral> result=new Result<>();
        //转诊
        Referral referral=new Referral();
        referral.setDoctorId(apply.getDoctorId());
        referral.setDepartmentId(apply.getDepartmentId());
        referral.setOutpatientType(apply.getOutpatientType());
        referral.setHospitalId(apply.getHospitalId());
        referral.setAppointmentTime(apply.getAppointmentTime());
        referral.setRemarks(apply.getRemarks());
        referral.setCreateTime(new Date());
        referral.setState(1);
        //患者
        SuffererDetails suffererDetails=new SuffererDetails();
        suffererDetails.setSuffererName(apply.getSuffererName());
        suffererDetails.setSuffererPhone(apply.getSuffererPhone());
        suffererDetails.setCreateTime(new Date());
        //查询患者id
        QueryWrapper<SuffererDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sufferer_phone",apply.getSuffererPhone());
        SuffererDetails suffer = suffererDetailsService.getOne(queryWrapper);
        //患者id
        referral.setSuffererDetailsId(suffer.getId());
        //新增转诊信息
        Boolean falg=referralService.save(referral);
        QueryWrapper<Referral> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("doctor_id",referral.getDoctorId());
        queryWrapper2.eq("sufferer_details_id",suffer.getId());
        queryWrapper2.eq("appointment_time",referral.getAppointmentTime());
        if(falg){
            result.setResult(referralService.getOne(queryWrapper2));
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @ApiOperation("申请转诊-完成")
    @RequestMapping(value = "/finaRefer", method = RequestMethod.GET)
    public Result<?> finaRefer(ApplyRefer apply){
        Result<?> result=new Result<>();
        //患者
        SuffererDetails suffererDetails=new SuffererDetails();
        suffererDetails.setSuffererSex(apply.getSuffererSex());
        suffererDetails.setSuffererWeight(apply.getSuffererWeight());
        suffererDetails.setSuffererAge(apply.getSuffererAge());
        suffererDetails.setSuffererHeight(apply.getSuffererHeight());
        suffererDetails.setId(apply.getSuffererDetailsId());
        suffererDetailsService.updateById(suffererDetails);
        //转诊
        Referral referral=new Referral();
        referral.setChiefComplaint(apply.getChiefComplaint());
        referral.setPhysicalExamination(apply.getPhysicalExamination());
        referral.setProblemToBeSolved(apply.getProblemToBeSolved());
        referral.setId(apply.getId());
        referral.setUpdateTime(new Date());
        referral.setState(2);
        Boolean falg=referralService.updateById(referral);
        if(!falg){
            result.setSuccess(false);
        }
        return result;
    }

    @ApiOperation("查询转诊单-信息")
    @RequestMapping(value = "/findReferInfo", method = RequestMethod.GET)
    public Result<ApplyRefer> findReferInfo(String id){
        Result<ApplyRefer> result=new Result<>();
        result.setResult(referralService.findZDanInfo(id));
        return result;
    }

    @ApiOperation("查询门诊类型")
    @RequestMapping(value = "/findReferType", method = RequestMethod.GET)
    public Result<List<ReferralType>> findReferType(){
        Result<List<ReferralType>> result=new Result<>();
        result.setResult(referralTypeService.list());
        return result;
    }

    @ApiOperation("取消预约")
    @RequestMapping(value = "/delRefer", method = RequestMethod.GET)
    public Result<?> delGroup(String id){
        Result<?> result=new Result<>();
        Boolean falg=referralService.removeById(id);
        if(falg){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @ApiOperation("打印单")
    @RequestMapping(value = "/lookRefer", method = RequestMethod.GET)
    public Result<?> updGroup(String id){
        Result<?> result=new Result<>();
        Referral referral=new Referral();
        referral.setId(Integer.valueOf(id));
        referral.setState(4);
        Boolean falg=referralService.updateById(referral);
        if(falg){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @ApiOperation("聊天")
    @RequestMapping(value = "/chatRefer", method = RequestMethod.GET)
    public Result<List<ChattingRecords>> chatRefer(String id,String doctorId){
        Result<List<ChattingRecords>> result=new Result<>();
        result.setResult(chattingRecordsService.findByRefer(id, doctorId));
        return result;
    }

    @ApiOperation("发送聊天")
    @RequestMapping(value = "/addChatRefer", method = RequestMethod.GET)
    public Result<?> addChatRefer(ChattingRecords chattingRecords){
        Result<?> result=new Result<>();
        chattingRecords.setHaveRead(2);
        chattingRecords.setIsDoct(1);
        chattingRecords.setCreateTime(new Date());
        Boolean falg=chattingRecordsService.save(chattingRecords);
        if(falg){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }
}
