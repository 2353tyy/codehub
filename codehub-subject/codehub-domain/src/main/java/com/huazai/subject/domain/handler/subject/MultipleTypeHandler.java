package com.huazai.subject.domain.handler.subject;

import com.huazai.subject.common.enums.SubjectInfoTypeEnum;
import com.huazai.subject.domain.convert.MultipleSubjectConverter;
import com.huazai.subject.domain.convert.RadioSubjectConverter;
import com.huazai.subject.domain.entity.SubjectInfoBO;
import com.huazai.subject.domain.entity.SubjectOptionBO;
import com.huazai.subject.infra.basic.entity.SubjectMultiple;
import com.huazai.subject.infra.basic.entity.SubjectRadio;
import com.huazai.subject.infra.basic.service.SubjectMultipleService;
import com.huazai.subject.infra.basic.service.SubjectRadioService;
import com.huazai.subject.infra.basic.service.impl.SubjectMultipleServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class MultipleTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectInfoTypeEnum getSubjectInfoTypeEnum() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //多选题目插入
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultiple subjectMultiple =
                    MultipleSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.insertBatch(subjectMultipleList);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        return null;
    }


}
