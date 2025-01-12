package com.huazai.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目分类(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2024-12-02 21:36:20
 */
@Data
public class SubjectCategoryBO implements Serializable {
/**
     * 主键
     */
    private Integer id;

/**
     * 分类名称
     */
    private String categoryName;

/**
     * 分类的类型
     */
    private Integer categoryType;

/**
     * 图标链接
     */
    private String imageUrl;

/**
     * 父级id
     */
    private Integer parentId;

}

