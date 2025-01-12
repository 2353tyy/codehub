package com.huazai.subject.domain.service.impl;

import com.huazai.subject.common.entity.PageResult;
import com.huazai.subject.domain.convert.SubjectInfoConverter;
import com.huazai.subject.domain.entity.SubjectInfoBO;
import com.huazai.subject.domain.entity.SubjectOptionBO;
import com.huazai.subject.domain.handler.subject.SubjectTypeHandler;
import com.huazai.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.huazai.subject.domain.service.SubjectInfoDomainService;
import com.huazai.subject.infra.basic.entity.SubjectInfo;
import com.huazai.subject.infra.basic.entity.SubjectLabel;
import com.huazai.subject.infra.basic.entity.SubjectMapping;
import com.huazai.subject.infra.basic.service.SubjectInfoService;
import com.huazai.subject.infra.basic.service.SubjectLabelService;
import com.huazai.subject.infra.basic.service.SubjectMappingService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;
    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;
    @Resource
    private SubjectMappingService subjectMappingService;
    @Resource
    private SubjectLabelService subjectLabelService;

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBoToInfo(subjectInfoBO);
        subjectInfoService.insert(subjectInfo);
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        subjectInfoBO.setId(subjectInfo.getId());
        handler.add(subjectInfoBO);
        List<Integer> labelIdS = subjectInfoBO.getLabelIds();
        List<SubjectMapping> mappingList = new LinkedList<>();
        subjectInfoBO.getCategoryIds().forEach(categoryId -> labelIdS.forEach(labelId -> {
            SubjectMapping subjectMapping = new SubjectMapping();
            subjectMapping.setSubjectId(subjectInfo.getId());
            subjectMapping.setCategoryId(categoryId);
            subjectMapping.setLabelId(labelId);
            mappingList.add(subjectMapping);
        }));
        subjectMappingService.insertBatch(mappingList);
    }

    @Override
    public PageResult<SubjectInfoBO>  getSubjectPage(SubjectInfoBO subjectInfoBO) {
        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBO.getPageNo());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        Integer start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBoToInfo(subjectInfoBO);
        int count = subjectInfoService.countByCondition(subjectInfo,subjectInfoBO.getCategoryId(),subjectInfoBO.getLabelId());
        if (log.isInfoEnabled()){
            log.info("查询条件：{}",subjectInfo);
            log.info("查询条件：{}",count);
        }
        if (count == 0){
            return pageResult;
        }
        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo,subjectInfoBO.getCategoryId(),
                subjectInfoBO.getLabelId(),start,subjectInfoBO.getPageSize());
        List<SubjectInfoBO> subjectInfoBOList = SubjectInfoConverter.INSTANCE.convertListBoToInfo(subjectInfoList);
        pageResult.setRecords(subjectInfoBOList);
        pageResult.setTotal(count);
        return pageResult;
    }

    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {
        SubjectInfo subjectInfo = subjectInfoService.queryById(subjectInfoBO.getId());
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        SubjectOptionBO optionBO = handler.query(subjectInfo.getId());
        SubjectInfoBO bo = SubjectInfoConverter.INSTANCE.convertOptionAndInfoToBo(optionBO,subjectInfo);

        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(subjectInfo.getId());
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelId(subjectMapping);
        List<Integer> labelIdList = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<String> labelNameList = labelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
        bo.setLabelName(labelNameList);
        return bo;
    }
}
