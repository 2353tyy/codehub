package com.huazai.subject.domain.convert;


import com.huazai.subject.domain.entity.SubjectLabelBO;
import com.huazai.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectLabelConverter {

    // 创建一个转换器
    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);
    // 将BO转换为实体类
    SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO);
    // 将实体类转换为BO
    SubjectLabelBO convertBoToLabel(SubjectLabel subjectLabel);
}
