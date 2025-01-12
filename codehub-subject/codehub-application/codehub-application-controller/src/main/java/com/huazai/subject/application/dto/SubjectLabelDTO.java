package com.huazai.subject.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class SubjectLabelDTO implements Serializable {
    private static final long serialVersionUID = 617957306524118850L;
/**
     * 主键
     */
    private Integer id;
    /**
     * 分类id
     */
    private Integer categoryId;
    /**
     * 标签名称
     */
    @NotEmpty
    private String labelName;
/**
     * 排序
     */
    @NotNull
    private Integer sortNum;

}

