package com.huazai.subject.domain.service;

import com.huazai.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

public interface SubjectCategoryDomainService {

    /**
     * 添加分类
     *
     */
    void addSubjectCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询一级分类
     * @return List<SubjectCategoryBO>
     */
    List<SubjectCategoryBO>  queryCategoryList();
    /**
     * 查询二级分类
     * @return List<SubjectCategoryBO>
     */
    List<SubjectCategoryBO> queryCategoryListById(SubjectCategoryBO subjectCategoryBO);

    /**
     * 更新分类
     */
    void updateSubjectCategory(SubjectCategoryBO subjectCategoryBO);

    boolean deleteById(Integer id);
}
