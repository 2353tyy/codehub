package com.huazai.subject.domain.entity;

import lombok.Data;

import java.util.List;

@Data
public class SubjectOptionBO {
    /**
     * 答案选项标识
     */
    private Integer optionType;
    /**
     *答案
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private String isCorrect;

    private String subjectAnswer;

    private List<SubjectAnswerBO> optionList;
}

