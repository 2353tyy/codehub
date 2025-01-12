package com.huazai.subject.application.dto;

import com.huazai.subject.common.entity.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import java.util.List;

/**
 * 题目DTO
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SubjectInfoDTO extends PageInfo implements Serializable {
/**
     * 主键
     */
    private Integer id;
/**
     * 题目名称
     */
    private String subjectName;
/**
     * 题目难度
     */
    private Integer subjectDifficult;
/**
     * 出题人名
     */
    private String settleName;
/**
     * 题目类型 1、单选 2、多选 3、判断 4、简答
     */
    private Integer subjectType;
/**
     * 题目分数
     */
    private Integer subjectScore;
/**
     * 题目解析
     */
    private String subjectParse;
/**
     * 题目答案
     */
    private String subjectAnswer;
/**
     * 题目分类id
     */
    private List<Integer> categoryIds;
/**
 * 标签id
 */
    private List<Integer> labelIds;
/**
 * 答案选项
 */
    private List<SubjectAnswerDTO> optionList;

    private Integer CategoryId;

    private Integer labelId;
}

