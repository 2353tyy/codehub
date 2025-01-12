package com.huazai.subject.infra.basic.service.impl;

import com.huazai.subject.infra.basic.entity.SubjectMapping;
import com.huazai.subject.infra.basic.mapper.SubjectMappingDao;
import com.huazai.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * 题目分类关系表(SubjectMapping)表服务实现类
 *
 * @author makejava
 * @since 2024-12-14 11:08:33
 */
@Service("subjectMappingService")
public class SubjectMappingServiceImpl implements SubjectMappingService {
    @Resource
    private SubjectMappingDao subjectMappingDao;

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public SubjectMapping queryById( ) {
        return this.subjectMappingDao.queryById();
    }



    /**
     * 新增数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectMapping insert(SubjectMapping subjectMapping) {
        this.subjectMappingDao.insert(subjectMapping);
        return subjectMapping;
    }

    /**
     * 修改数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectMapping update(SubjectMapping subjectMapping) {
        this.subjectMappingDao.update(subjectMapping);
        return this.queryById();
    }

    /**
     * 通过主键删除数据
     * @return 是否成功
     */
    @Override
    public boolean deleteById( ) {
        return this.subjectMappingDao.deleteById() > 0;
    }

    @Override
    public List<SubjectMapping> queryLabelId(SubjectMapping subjectMapping) {
        return this.subjectMappingDao.queryLabelId(subjectMapping);
    }

    @Override
    public void insertBatch(List<SubjectMapping> mappingList) {
        this.subjectMappingDao.insertBatch(mappingList);
    }
}
