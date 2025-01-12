package com.huazai.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.huazai.subject.application.convert.SubjectAnswerDTOConverter;
import com.huazai.subject.application.convert.SubjectInfoDTOConverter;
import com.huazai.subject.application.dto.SubjectInfoDTO;
import com.huazai.subject.common.entity.PageResult;
import com.huazai.subject.common.entity.Result;
import com.huazai.subject.domain.entity.SubjectAnswerBO;
import com.huazai.subject.domain.entity.SubjectInfoBO;
import com.huazai.subject.domain.service.SubjectInfoDomainService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/subject")
public class subjectController {
    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;

    /**
     * 新增题目
     */
    @PostMapping("add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
            if (log.isInfoEnabled()){
                log.info("添加题目列表:{}", JSON.toJSONString(subjectInfoDTO));
            }
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToBo(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOList =
                    SubjectAnswerDTOConverter.INSTANCE.convertDtoToBo(subjectInfoDTO.getOptionList());
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.success(true);
        }catch (Exception e){
            log.error("subjectController.add.error:{}",e.getMessage(),e);
            return Result.fail(false);
        }
    }

    /**
     * 查询题目列表
     */
    @PostMapping("getSubjectPage")
    public Result<PageResult<SubjectInfoBO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
        if (log.isInfoEnabled()){
            log.info("查询题目列表DTO:{}", JSON.toJSONString(subjectInfoDTO));
        }
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToBo(subjectInfoDTO);
        if (log.isInfoEnabled()){
            log.info("查询题目列表BO:{}", JSON.toJSONString(subjectInfoBO));
        }
            PageResult<SubjectInfoBO> boPageResult =  subjectInfoDomainService.getSubjectPage(subjectInfoBO);
            return Result.success(boPageResult);
        }catch (Exception e){
            log.error("subjectController.add.error:{}",e.getMessage(),e);
//            return Result.fail("分页查询题目失败");
            return Result.fail();
        }
    }

    @PostMapping("querySubjectInfo")
    public Result<SubjectInfoBO> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
            if (log.isInfoEnabled()){
                log.info("查询题目列表DTO:{}", JSON.toJSONString(subjectInfoDTO));
            }
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToBo(subjectInfoDTO);
            if (log.isInfoEnabled()){
                log.info("查询题目列表BO:{}", JSON.toJSONString(subjectInfoBO));
            }
            SubjectInfoBO boResult =  subjectInfoDomainService.querySubjectInfo(subjectInfoBO);
            return Result.success(boResult);
        }catch (Exception e){
            log.error("subjectController.add.error:{}",e.getMessage(),e);
//            return Result.fail("分页查询题目失败");
            return Result.fail();
        }
    }
}
