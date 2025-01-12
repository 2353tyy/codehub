package com.huazai.subject.domain.convert;


import com.huazai.subject.domain.entity.SubjectAnswerBO;
import com.huazai.subject.domain.entity.SubjectInfoBO;
import com.huazai.subject.infra.basic.entity.SubjectInfo;
import com.huazai.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RadioSubjectConverter {

    // 创建一个转换器
    RadioSubjectConverter INSTANCE = Mappers.getMapper(RadioSubjectConverter.class);
    // 将BO转换为实体类
    SubjectRadio convertBoToEntity(SubjectAnswerBO subjectAnswerBO);
}
