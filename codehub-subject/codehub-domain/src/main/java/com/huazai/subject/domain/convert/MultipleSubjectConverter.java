package com.huazai.subject.domain.convert;


import com.huazai.subject.domain.entity.SubjectAnswerBO;
import com.huazai.subject.infra.basic.entity.SubjectMultiple;
import com.huazai.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MultipleSubjectConverter {

    // 创建一个转换器
    MultipleSubjectConverter INSTANCE = Mappers.getMapper(MultipleSubjectConverter.class);
    // 将BO转换为实体类
    SubjectMultiple convertBoToEntity(SubjectAnswerBO subjectAnswerBO);
}
