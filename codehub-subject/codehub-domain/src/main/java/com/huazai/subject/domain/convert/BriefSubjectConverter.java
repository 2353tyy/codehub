package com.huazai.subject.domain.convert;


import com.huazai.subject.domain.entity.SubjectAnswerBO;
import com.huazai.subject.domain.entity.SubjectInfoBO;
import com.huazai.subject.infra.basic.entity.SubjectBrief;
import com.huazai.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BriefSubjectConverter {

    // 创建一个转换器
    BriefSubjectConverter INSTANCE = Mappers.getMapper(BriefSubjectConverter.class);
    // 将BO转换为实体类
    SubjectBrief convertBoToEntity(SubjectInfoBO subjectInfoBO);
}
