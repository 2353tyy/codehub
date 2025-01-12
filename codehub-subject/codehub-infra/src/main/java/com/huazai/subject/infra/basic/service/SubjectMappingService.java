package com.huazai.subject.infra.basic.service;

import com.huazai.subject.infra.basic.entity.SubjectMapping;

import java.util.List;


/**
 * 题目分类关系表(SubjectMapping)表服务接口
 *
 * @author makejava
 * @since 2024-12-14 11:08:33
 */
public interface SubjectMappingService {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    SubjectMapping queryById( );


    /**
     * 新增数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    SubjectMapping insert(SubjectMapping subjectMapping);

    /**
     * 修改数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    SubjectMapping update(SubjectMapping subjectMapping);

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    boolean deleteById( );

    /**
     * 查询标签id
     */
    List<SubjectMapping> queryLabelId(SubjectMapping subjectMapping);

    void insertBatch(List<SubjectMapping> mappingList);
}
