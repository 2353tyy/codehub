package com.huazai.subject.application.convert;

import com.huazai.subject.application.dto.SubjectCategoryDTO;
import com.huazai.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryDTOConverter {
    // 创建一个转换器
    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);
    // 将DTO转换为BO
    SubjectCategoryBO convertBoToCategory(SubjectCategoryDTO subjectCategoryDTO);
    // 将List<BO>转换为List<DTO>
    List<SubjectCategoryDTO> convertBoToCategory(List<SubjectCategoryBO> subjectCategoryBO);
}
