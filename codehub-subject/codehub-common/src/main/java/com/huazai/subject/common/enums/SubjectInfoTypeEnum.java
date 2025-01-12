package com.huazai.subject.common.enums;

import lombok.Getter;

/**
 * 题目类型枚举
 * 1、单选题 2、多选题 3、判断题 4、解答题
 */
@Getter
public enum SubjectInfoTypeEnum {
    RADIO(1, "单选"),
    MULTIPLE(2, "多选"),
    JUDGE(3, "判断"),
    BRIEF(4, "解答");
    private final Integer code;
    private final String message;
    SubjectInfoTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public static SubjectInfoTypeEnum getByCode(Integer codeVal) {
        for (SubjectInfoTypeEnum subjectInfoTypeEnum : SubjectInfoTypeEnum.values()) {
            if (subjectInfoTypeEnum.getCode().equals(codeVal)) {
                return subjectInfoTypeEnum;
            }
        }
        return null;
    }
}
