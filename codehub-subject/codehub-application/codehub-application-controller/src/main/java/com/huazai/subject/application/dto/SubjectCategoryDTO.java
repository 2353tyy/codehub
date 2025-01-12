package com.huazai.subject.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;

/**
 * 题目分类(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2024-12-02 21:36:20
 */
@Data
public class SubjectCategoryDTO implements Serializable {
    private static final long serialVersionUID = 244605737496442646L;
    /**
     * 主键
     */
    private Integer id;

/**
     * 分类名称
     */
    @NotEmpty
    private String categoryName;

/**
     * 分类的类型
     */
    @NotNull
    private Integer categoryType;

/**
     * 图标链接
     */
    @NotEmpty
    @URL
    private String imageUrl;

/**
     * 父级id
     */
    @NotNull
    private Integer parentId;

}

