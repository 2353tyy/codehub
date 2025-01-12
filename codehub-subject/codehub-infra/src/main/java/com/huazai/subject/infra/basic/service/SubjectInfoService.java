package com.huazai.subject.infra.basic.service;

import com.huazai.subject.infra.basic.entity.SubjectInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 题目信息表(SubjectInfo)表服务接口
 *
 * @author makejava
 * @since 2024-12-17 13:27:50
 */
public interface SubjectInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectInfo queryById(Integer id);


    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo insert(SubjectInfo subjectInfo);

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo update(SubjectInfo subjectInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    int countByCondition(@Param("subjectInfo") SubjectInfo subjectInfo,
                         @Param("categoryId") Integer categoryId,
                         @Param("labelId") Integer labelId);

    List<SubjectInfo> queryPage(@Param("subjectInfo") SubjectInfo subjectInfo,
                                @Param("categoryId") Integer categoryId,
                                @Param("start") Integer labelId,
                                @Param("pageSize") Integer start,
                                @Param("pageSize") Integer pageSize);
}
