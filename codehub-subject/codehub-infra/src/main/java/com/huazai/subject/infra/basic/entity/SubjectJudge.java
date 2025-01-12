package com.huazai.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 判断题(SubjectJudge)实体类
 *
 * @author makejava
 * @since 2024-12-17 13:29:52
 */
@Data
public class SubjectJudge implements Serializable {
    private static final long serialVersionUID = 879417553684112926L;
/**
     * 主键
     */
    private Integer id;
/**
     * 题目id
     */
    private Integer subjectId;
/**
     * 是否正确
     */
    private Integer isCorrect;
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

