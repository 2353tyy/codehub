package com.huazai.subject.infra.basic.service.impl;

import com.huazai.subject.infra.basic.entity.SubjectLabel;
import com.huazai.subject.infra.basic.mapper.SubjectLabelDao;
import com.huazai.subject.infra.basic.service.SubjectLabelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2024-12-14 09:19:35
 */
@Service("subjectLabelService")
public class SubjectLabelServiceImpl implements SubjectLabelService {
    @Resource
    private SubjectLabelDao subjectLabelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLabel queryById(Integer id) {
        return this.subjectLabelDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLabel insert(SubjectLabel subjectLabel) {
        this.subjectLabelDao.insert(subjectLabel);
        return subjectLabel;
    }

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLabel update(SubjectLabel subjectLabel) {
        this.subjectLabelDao.update(subjectLabel);
        return this.queryById(subjectLabel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.subjectLabelDao.deleteById(id) > 0;
    }

    @Override
    public List<SubjectLabel> batchQueryById(List<Integer> labelIdList) {
        return this.subjectLabelDao.batchQueryById(labelIdList);
    }
}
