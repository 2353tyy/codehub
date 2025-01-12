package com.huazai.subject.domain.convert;


import com.huazai.subject.domain.entity.SubjectInfoBO;
import com.huazai.subject.domain.entity.SubjectOptionBO;
import com.huazai.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoConverter {

    // 创建一个转换器
    SubjectInfoConverter INSTANCE = Mappers.getMapper(SubjectInfoConverter.class);
    // 将BO转换为实体类
    SubjectInfo convertBoToInfo(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoBO> convertListBoToInfo(List<SubjectInfo> subjectInfoList);

    SubjectInfoBO convertOptionAndInfoToBo(SubjectOptionBO optionBO, SubjectInfo subjectInfo);
}
