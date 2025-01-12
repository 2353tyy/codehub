package com.huazai.subject.infra.basic.service;

import com.huazai.subject.infra.basic.entity.SubjectBrief;

import java.util.List;

/**
 * 简答题(SubjectBrief)表服务接口
 *
 * @author makejava
 * @since 2024-12-17 13:29:23
 */
public interface SubjectBriefService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectBrief queryById(Integer id);


    /**
     * 新增数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    SubjectBrief insert(SubjectBrief subjectBrief);

    /**
     * 修改数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    SubjectBrief update(SubjectBrief subjectBrief);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 条件查询
     *
     * @param subjectBrief 实例对象
     * @return 对象列表
     */
    SubjectBrief queryByCondition(SubjectBrief subjectBrief);
}
