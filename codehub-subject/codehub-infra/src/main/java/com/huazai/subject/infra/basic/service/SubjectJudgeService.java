package com.huazai.subject.infra.basic.service;

import com.huazai.subject.infra.basic.entity.SubjectJudge;

import java.util.List;

/**
 * 判断题(SubjectJudge)表服务接口
 *
 * @author makejava
 * @since 2024-12-17 13:29:52
 */
public interface SubjectJudgeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectJudge queryById(Integer id);

    /**
     * 新增数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    SubjectJudge insert(SubjectJudge subjectJudge);

    /**
     * 修改数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    SubjectJudge update(SubjectJudge subjectJudge);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<SubjectJudge> queryByCondition(SubjectJudge subjectJudge);
}
