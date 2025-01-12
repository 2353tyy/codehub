 package com.huazai.subject.application.convert;


import com.huazai.subject.application.dto.SubjectAnswerDTO;
import com.huazai.subject.application.dto.SubjectInfoDTO;
import com.huazai.subject.application.dto.SubjectLabelDTO;
import com.huazai.subject.domain.entity.SubjectInfoBO;
import com.huazai.subject.domain.entity.SubjectLabelBO;
import com.huazai.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoDTOConverter {
    // 创建一个转换器
    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);
    // 将DTO转换为BO
    SubjectInfoBO convertDtoToBo(SubjectInfoDTO subjectInfoDTO);
}
