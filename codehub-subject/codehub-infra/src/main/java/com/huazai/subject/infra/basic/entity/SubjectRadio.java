package com.huazai.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 单选题信息表(SubjectRadio)实体类
 *
 * @author makejava
 * @since 2024-12-17 13:30:52
 */
@Data
public class SubjectRadio implements Serializable {
    private static final long serialVersionUID = -85573639074670338L;
/**
     * 主键
     */
    private Integer id;
/**
     * 题目id
     */
    private Integer subjectId;
/**
     * a,b,c,d,e
     */
    private Integer optionType;
/**
     * 选项内容
     */
    private String optionContent;
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

