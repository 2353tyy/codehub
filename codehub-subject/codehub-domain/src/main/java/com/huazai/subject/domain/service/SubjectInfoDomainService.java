package com.huazai.subject.domain.service;


import com.huazai.subject.common.entity.PageResult;
import com.huazai.subject.domain.entity.SubjectInfoBO;



public interface SubjectInfoDomainService {

    /**
     * 新增题目
     *
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询题目
     *
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
