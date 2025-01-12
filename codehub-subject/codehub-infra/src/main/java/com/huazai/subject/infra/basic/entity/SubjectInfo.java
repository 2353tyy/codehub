package com.huazai.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目信息表(SubjectInfo)实体类
 *
 * @author makejava
 * @since 2024-12-17 13:27:50
 */
@Data
public class SubjectInfo implements Serializable {
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

