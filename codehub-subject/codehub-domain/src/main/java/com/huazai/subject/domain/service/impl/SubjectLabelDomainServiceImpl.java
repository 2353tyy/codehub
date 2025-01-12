package com.huazai.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.huazai.subject.domain.convert.SubjectLabelConverter;
import com.huazai.subject.domain.entity.SubjectLabelBO;
import com.huazai.subject.domain.service.SubjectLabelDomainService;
import com.huazai.subject.infra.basic.entity.SubjectLabel;
import com.huazai.subject.infra.basic.entity.SubjectMapping;
import com.huazai.subject.infra.basic.service.SubjectLabelService;
import com.huazai.subject.infra.basic.service.SubjectMappingService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Override
    public void addSubjectLabel(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE
                .convertBoToLabel(subjectLabelBO);
        subjectLabelService.insert(subjectLabel);
    }

    @Override
    public void updateSubjectLabel(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE
                .convertBoToLabel(subjectLabelBO);
        if(log.isDebugEnabled()){
            log.debug("SubjectLabelDomainServiceImpl.updateSubjectLabel.subjectLabel:{}",subjectLabel);
        }
        subjectLabelService.update(subjectLabel);
    }

    @Override
    public boolean deleteById(Integer id) {
        return subjectLabelService.deleteById(id);
    }

    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        Integer categoryId = subjectLabelBO.getCategoryId();
        SubjectMapping subjectMapping = new SubjectMapping();
        if(log.isInfoEnabled()){
            log.info("categoryId:{}",categoryId);
        }
        subjectMapping.setCategoryId(categoryId);
//        subjectMapping.setIsDeleted();
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelId(subjectMapping);
        if(CollectionUtils.isEmpty(subjectMappingList)){
            return Collections.emptyList();
        }
        List<Integer> labelIdList = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        if(log.isInfoEnabled()){
            log.info("labelIdList:{}",labelIdList);
        }
        List<SubjectLabel> subjectLabelList = subjectLabelService.batchQueryById(labelIdList);
        if(log.isInfoEnabled()){
            log.info("subjectLabelList:{}", JSON.toJSONString(subjectLabelList));
        }
        List<SubjectLabelBO> subjectLabelBOList = new LinkedList<>();
        subjectLabelList.forEach(subjectLabel -> {
            SubjectLabelBO bo = new SubjectLabelBO();
            bo.setId(subjectLabel.getId());
            bo.setLabelName(subjectLabel.getLabelName());
            bo.setSortNum(subjectLabel.getSortNum());
            subjectLabelBOList.add(bo);
        });
        return subjectLabelBOList;
    }
}
