package com.huazai.subject.application.convert;


import com.huazai.subject.application.dto.SubjectLabelDTO;
import com.huazai.subject.domain.entity.SubjectLabelBO;
import com.huazai.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectLabelDTOConverter {
    // 创建一个转换器
    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);
    // 将DTO转换为BO
    SubjectLabelBO convertDtoToBo(SubjectLabelDTO subjectLAbelDTO);
    // 将BO转换为DTO
    SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO);
    // 将List<BO>转换为List<DTO>
    List<SubjectLabelDTO> convertBoToDto(List<SubjectLabelBO> subjectLabelBO);

}
