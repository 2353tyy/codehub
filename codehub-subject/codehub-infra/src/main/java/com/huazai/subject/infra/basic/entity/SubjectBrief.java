package com.huazai.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 简答题(SubjectBrief)实体类
 *
 * @author makejava
 * @since 2024-12-17 13:29:23
 */
@Data
public class SubjectBrief implements Serializable {
    private static final long serialVersionUID = -48630314259573037L;
/**
     * 主键
     */
    private Integer id;
/**
     * 题目答案
     */
    private String subjectAnswer;
/**
     * 题目id
     */
    private Integer subjectId;
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

