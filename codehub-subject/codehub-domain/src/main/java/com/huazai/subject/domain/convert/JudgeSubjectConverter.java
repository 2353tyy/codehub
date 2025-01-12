package com.huazai.subject.domain.convert;


import com.huazai.subject.domain.entity.SubjectAnswerBO;
import com.huazai.subject.domain.entity.SubjectInfoBO;
import com.huazai.subject.infra.basic.entity.SubjectBrief;
import com.huazai.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JudgeSubjectConverter {

    // 创建一个转换器
    JudgeSubjectConverter INSTANCE = Mappers.getMapper(JudgeSubjectConverter.class);
    // 将BO转换为实体类
    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectJudge> subjectJudgeList);
}
