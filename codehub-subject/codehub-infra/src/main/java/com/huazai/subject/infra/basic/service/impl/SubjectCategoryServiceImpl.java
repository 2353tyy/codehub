package com.huazai.subject.infra.basic.service.impl;

import com.huazai.subject.infra.basic.entity.SubjectCategory;
import com.huazai.subject.infra.basic.mapper.SubjectCategoryDao;
import com.huazai.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 题目分类(SubjectCategory)表服务实现类
 *
 * @author makejava
 * @since 2024-12-02 21:36:27
 */
@Slf4j
@Service("subjectCategoryService")
public class SubjectCategoryServiceImpl implements SubjectCategoryService {
    @Resource
    private SubjectCategoryDao subjectCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectCategory queryById(Integer id) {
        return this.subjectCategoryDao.queryById(id);
    }

    @Override
    public List<SubjectCategory> queryPrimaryCategory(SubjectCategory subjectCategory) {
        return this.subjectCategoryDao.queryPrimaryCategory(subjectCategory);
    }




    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory insert(SubjectCategory subjectCategory) {
        log.info("新增题目分类，subjectCategory为：{}", subjectCategory);
        this.subjectCategoryDao.insert(subjectCategory);
        return subjectCategory;
    }

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory update(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.update(subjectCategory);
        return this.queryById(subjectCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.subjectCategoryDao.deleteById(id) > 0;
    }
}
