package com.huazai.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目标签dto
 *
 * @author to t
 * @since 2024-12-14 09:19:35
 */
@Data
public class SubjectLabelBO implements Serializable {
    private static final long serialVersionUID = 617957306524118850L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 标签名称
     */
    private String labelName;
    /**
     * 题目分类id
     */
    private Integer categoryId;
    /**
     * 排序
     */
    private Integer sortNum;


}

