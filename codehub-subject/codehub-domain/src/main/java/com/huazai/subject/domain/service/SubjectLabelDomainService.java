package com.huazai.subject.domain.service;


import com.huazai.subject.common.entity.Result;
import com.huazai.subject.domain.entity.SubjectLabelBO;

import java.util.List;


public interface SubjectLabelDomainService {

    /**
     * 添加标签
     *
     */
    void addSubjectLabel(SubjectLabelBO  subjectLabelBO);


    /**
     * 更新标签
     */
    void updateSubjectLabel(SubjectLabelBO subjectLabelBO);

    /**
     * 删除标签
     */
    boolean deleteById(Integer id);

    /**
     * 根据分类id查询标签
     */
    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);
}
