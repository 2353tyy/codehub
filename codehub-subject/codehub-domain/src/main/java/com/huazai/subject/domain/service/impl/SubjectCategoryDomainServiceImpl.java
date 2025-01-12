package com.huazai.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.huazai.subject.domain.convert.SubjectCategoryConverter;
import com.huazai.subject.domain.entity.SubjectCategoryBO;
import com.huazai.subject.domain.service.SubjectCategoryDomainService;
import com.huazai.subject.infra.basic.entity.SubjectCategory;
import com.huazai.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService{

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void addSubjectCategory(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()){
            log.info("新增分类，subjectCategoryBO为：{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryCategoryList() {
        SubjectCategory subjectCategory = new SubjectCategory();
        subjectCategory.setParentId(0);
        subjectCategory.setCategoryType(1);
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryPrimaryCategory(subjectCategory);
        return SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryList);
    }

    @Override
    public List<SubjectCategoryBO> queryCategoryListById(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryPrimaryCategory(subjectCategory);
        return SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryList);
    }

    @Override
    public void updateSubjectCategory(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()){
            log.info("更新分类，subjectCategoryBO为：{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategoryService.update(subjectCategory);
    }

    @Override
    public boolean deleteById(Integer id) {
        SubjectCategory subjectCategory = new SubjectCategory();
        subjectCategory.setId(id);
        return subjectCategoryService.deleteById(id);
    }
}
