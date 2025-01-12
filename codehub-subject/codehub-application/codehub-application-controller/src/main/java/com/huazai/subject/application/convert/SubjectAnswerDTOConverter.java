 package com.huazai.subject.application.convert;


import com.huazai.subject.application.dto.SubjectAnswerDTO;
import com.huazai.subject.application.dto.SubjectInfoDTO;
import com.huazai.subject.domain.entity.SubjectAnswerBO;
import com.huazai.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

 @Mapper
 public interface SubjectAnswerDTOConverter {
     // 创建一个转换器
     SubjectAnswerDTOConverter INSTANCE = Mappers.getMapper(SubjectAnswerDTOConverter.class);
     // 将DTO转换为BO
     List<SubjectAnswerBO> convertDtoToBo(List<SubjectAnswerDTO> dtoList);
 }
