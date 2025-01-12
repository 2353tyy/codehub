package com.huazai.subject.domain.handler.subject;

import com.huazai.subject.common.enums.SubjectInfoTypeEnum;
import com.huazai.subject.domain.entity.SubjectInfoBO;
import com.huazai.subject.domain.entity.SubjectOptionBO;

public interface SubjectTypeHandler {

    /**
     * 枚举身份识别
     */
    SubjectInfoTypeEnum getSubjectInfoTypeEnum();

    /**
     * 题目插入
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 题目查询
     */
    SubjectOptionBO query(int subjectId);
}
