package com.cskt.historl.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cskt.historl.entity.*;
import com.cskt.historl.service.*;
import com.cskt.historl.util.Result;
import com.cskt.historl.vo.ApplyGroupConsultation;
import com.cskt.historl.vo.GroupList;
import com.cskt.historl.vo.Myself;
import com.cskt.historl.vo.UserName;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 会诊接口
 * @author: Mr.阿九
 * @createTime: 2021-02-20 19:16
 **/
@RestController
@RequestMapping(value = "/group")
public class ConsultationController {
    @Resource
    private GroupConsultationService groupConsultationService;
    @Resource
    private SuffererDetailsService suffererDetailsService;
    @Resource
    private ChattingRecordsService chattingRecordsService;
    @Resource
    private HospitalDictionaryService HospitalDictionaryService;

    @ApiOperation("申请会诊-预约")
    @RequestMapping(value = "/addGroupConsultation", method = RequestMethod.GET)
    public Result<GroupConsultation> addGroupConsultation(ApplyGroupConsultation apply) throws ParseException {
        Result<GroupConsultation> result=new Result<>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //会诊
        GroupConsultation groupConsultation=new GroupConsultation();
        groupConsultation.setDoctorId(apply.getDoctorId());
        groupConsultation.setDepartmentId(apply.getDepartmentId());
        groupConsultation.setHospitalId(apply.getHospitalId());
        groupConsultation.setAppointmentTime(apply.getAppointmentTime());
        groupConsultation.setGroupConsultationApp(apply.getGroupConsultationApp());
        groupConsultation.setRemarks(apply.getRemarks());
        groupConsultation.setCreateTime(new Date());
        groupConsultation.setState(1);
        //患者
        SuffererDetails suffererDetails=new SuffererDetails();
        suffererDetails.setSuffererName(apply.getSuffererName());
        suffererDetails.setSuffererPhone(apply.getSuffererPhone());
        suffererDetails.setCreateTime(new Date());
        //判断患者信息是否存在
        QueryWrapper<SuffererDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sufferer_phone",apply.getSuffererPhone());
        SuffererDetails suffer = suffererDetailsService.getOne(queryWrapper);
        //不存在
        if(suffer==null){
            //新增患者信息
            suffererDetailsService.save(suffererDetails);
            suffer = suffererDetailsService.getOne(queryWrapper);
        }
        //患者id
        groupConsultation.setSuffererDetailsId(suffer.getId());
        //新增会诊信息
        Boolean falg=groupConsultationService.save(groupConsultation);
        QueryWrapper<GroupConsultation> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("doctor_id",groupConsultation.getDoctorId());
        queryWrapper2.eq("sufferer_details_id",suffer.getId());
        queryWrapper2.eq("appointment_time",groupConsultation.getAppointmentTime());
        if(falg){
            result.setResult(groupConsultationService.getOne(queryWrapper2));
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @ApiOperation("申请会诊-完成")
    @RequestMapping(value = "/finaGroupConsultation", method = RequestMethod.GET)
    public Result<?> finaGroupConsultation(ApplyGroupConsultation apply){
        Result<?> result=new Result<>();
        //患者
        SuffererDetails suffererDetails=new SuffererDetails();
        suffererDetails.setSuffererSex(apply.getSuffererSex());
        suffererDetails.setSuffererWeight(apply.getSuffererWeight());
        suffererDetails.setSuffererAge(apply.getSuffererAge());
        suffererDetails.setSuffererHeight(apply.getSuffererHeight());
        suffererDetails.setId(apply.getSuffererDetailsId());
        suffererDetailsService.updateById(suffererDetails);
        //会诊
        GroupConsultation groupConsultation=new GroupConsultation();
        groupConsultation.setChiefComplaint(apply.getChiefComplaint());
        groupConsultation.setPhysicalExamination(apply.getPhysicalExamination());
        groupConsultation.setProblemToBeSolved(apply.getProblemToBeSolved());
        groupConsultation.setId(apply.getId());
        groupConsultation.setUpdateTime(new Date());
        groupConsultation.setState(2);
        groupConsultationService.updateById(groupConsultation);
        return result;
    }

    @ApiOperation("查询患者详情-信息")
    @RequestMapping(value = "/findSufferList", method = RequestMethod.GET)
    public Result<SuffererDetails> findSufferList(String sufferId){
        Result<SuffererDetails> result=new Result<>();
        result.setResult(suffererDetailsService.getById(sufferId));
        return result;
    }

    @ApiOperation("查询会诊列表-信息")
    @RequestMapping(value = "/findGroupList", method = RequestMethod.GET)
    public Result<List<GroupList>> findGroupList(String doctorId,String sufferName){
        Result<List<GroupList>> result=new Result<>();
        result.setResult(groupConsultationService.findHList(doctorId,sufferName));
        return result;
    }

    @ApiOperation("查询会诊单-信息")
    @RequestMapping(value = "/findHGroupInfo", method = RequestMethod.GET)
    public Result<ApplyGroupConsultation> findGroupInfo(String id){
        Result<ApplyGroupConsultation> result=new Result<>();
        result.setResult(groupConsultationService.findHDanInfo(id));
        return result;
    }

    @ApiOperation("查询会诊/转诊医生-信息")
    @RequestMapping(value = "/findGroupInfo", method = RequestMethod.GET)
    public Result<UserName> findUserName(String phone){
        Result<UserName> result=new Result<>();
        result.setResult(groupConsultationService.findUserNameInfo(phone));
        return result;
    }

    @ApiOperation("查询未读聊天条数")
    @RequestMapping(value = "/findChatNum", method = RequestMethod.GET)
    public Result<List<Integer>> findChatNum(String doctorId, String chatString){
        String[] integerList=chatString.split(",");
        Result<List<Integer>> result=new Result<>();
        List<Integer> chattingRecordsList=new ArrayList<>();
        QueryWrapper<ChattingRecords> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("doctor",doctorId);
        queryWrapper.eq("have_read",0);
        ChattingRecords chattingRecords=null;
        for (int i = 0; i <integerList.length; i++) {
            queryWrapper.eq("group_consultation_id",integerList[i]);
            chattingRecordsList.add(chattingRecordsService.count(queryWrapper));
        }
        result.setResult(chattingRecordsList);
        return result;
    }

    @ApiOperation("查询会诊医院")
    @RequestMapping(value = "/findHDepart", method = RequestMethod.GET)
    public Result<List<HospitalDictionary>> findHDepart(){
        Result<List<HospitalDictionary>> result=new Result<>();
        result.setResult(HospitalDictionaryService.list());
        return result;
    }

    @ApiOperation("取消预约")
    @RequestMapping(value = "/delGroup", method = RequestMethod.GET)
    public Result<?> delGroup(String id){
        Result<?> result=new Result<>();
        Boolean falg=groupConsultationService.removeById(id);
        if(falg){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @ApiOperation("待接诊")
    @RequestMapping(value = "/updGroup", method = RequestMethod.GET)
    public Result<?> updGroup(String id){
        Result<?> result=new Result<>();
        GroupConsultation groupConsultation=new GroupConsultation();
        groupConsultation.setId(Integer.valueOf(id));
        groupConsultation.setState(4);
        Boolean falg=groupConsultationService.updateById(groupConsultation);
        if(falg){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @ApiOperation("聊天")
    @RequestMapping(value = "/chatGroup", method = RequestMethod.GET)
    public Result<List<ChattingRecords>> chatGroup(String id,String doctorId){
        Result<List<ChattingRecords>> result=new Result<>();
        result.setResult(chattingRecordsService.findByGroup(id, doctorId));
        return result;
    }

}
