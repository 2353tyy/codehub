package com.huazai.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目分类(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2024-12-02 21:36:20
 */
@Data
public class SubjectCategory implements Serializable {
    private static final long serialVersionUID = 244605737496442646L;
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
/**
     * 创建人
     */
    private String createdBy;
/**
     * 创建时间
     */
    private Date createdTime;
/**
     * 更新人
     */
    private String updateBy;
/**
     * 更新时间
     */
    private Date updateTime;
}

