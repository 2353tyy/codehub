package com.huazai.subject.domain.handler.subject;

import com.huazai.subject.common.enums.SubjectInfoTypeEnum;
import com.huazai.subject.domain.convert.RadioSubjectConverter;
import com.huazai.subject.domain.entity.SubjectInfoBO;
import com.huazai.subject.domain.entity.SubjectOptionBO;
import com.huazai.subject.infra.basic.entity.SubjectRadio;
import com.huazai.subject.infra.basic.service.SubjectRadioService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class RadioTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getSubjectInfoTypeEnum() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //单选题目插入
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadio subjectRadio =
                    RadioSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.insertBatch(subjectRadioList);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        return null;
    }


}
