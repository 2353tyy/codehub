package com.huazai.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目分类关系表(SubjectMapping)实体类
 *
 * @author makejava
 * @since 2024-12-14 11:08:33
 */
@Data
public class SubjectMapping implements Serializable {
    private static final long serialVersionUID = -15718547025450175L;
/**
     * 主键
     */
    private Long id;
/**
     * 题目id
     */
    private Integer subjectId;
/**
     * 分类id
     */
    private Integer categoryId;
/**
     * 标签id
     */
    private Integer labelId;
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

    private Integer isDeleted;

}

