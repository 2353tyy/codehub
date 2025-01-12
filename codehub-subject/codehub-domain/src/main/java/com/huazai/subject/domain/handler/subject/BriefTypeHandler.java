package com.huazai.subject.domain.handler.subject;

import com.huazai.subject.common.enums.SubjectInfoTypeEnum;
import com.huazai.subject.domain.convert.BriefSubjectConverter;
import com.huazai.subject.domain.entity.SubjectInfoBO;
import com.huazai.subject.domain.entity.SubjectOptionBO;
import com.huazai.subject.infra.basic.entity.SubjectBrief;
import com.huazai.subject.infra.basic.service.SubjectBriefService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class BriefTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectBriefService subjectBriefService;
    @Override
    public SubjectInfoTypeEnum getSubjectInfoTypeEnum() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //解答题目插入
        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.convertBoToEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId());

        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectId);
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;
    }
}
