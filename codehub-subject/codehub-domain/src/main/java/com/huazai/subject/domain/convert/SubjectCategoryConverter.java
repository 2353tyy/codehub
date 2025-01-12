package com.huazai.subject.domain.convert;

import com.huazai.subject.domain.entity.SubjectCategoryBO;
import com.huazai.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryConverter {

    // 创建一个转换器
    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);
    // 将BO转换为实体类
    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);
    // 将实体类转换为BO
    List<SubjectCategoryBO> convertBoToCategory(List<SubjectCategory> subjectCategoryBO);
}
