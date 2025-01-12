package com.huazai.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.huazai.subject.application.convert.SubjectCategoryDTOConverter;
import com.huazai.subject.application.dto.SubjectCategoryDTO;
import com.huazai.subject.common.entity.Result;
import com.huazai.subject.domain.entity.SubjectCategoryBO;
import com.huazai.subject.domain.service.SubjectCategoryDomainService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/subject/category")
public class SubjectCategoryController {
    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 新增分类
     */
    @PostMapping("add")
    public Result<Boolean> addSubjectCategory(@Valid @RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategory(subjectCategoryDTO);
            subjectCategoryDomainService.addSubjectCategory(subjectCategoryBO);
            return Result.success(true);
        }catch (Exception e){
            log.error("SubjectCategoryController.add.error:{}",e.getMessage(),e);
            return Result.fail(false);
        }
    }
    /**
     * 查询一级分类
     */
    @GetMapping("queryCategoryList")
    public Result<List<SubjectCategoryDTO>> queryCategoryList() {
      try {
        List<SubjectCategoryBO> subjectCategoryBoList = subjectCategoryDomainService.queryCategoryList();
        List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBoList);
        return  Result.success(subjectCategoryDTOList );
      }catch (Exception e){
        log.error("SubjectCategoryController.queryCategoryList.error:{}",e.getMessage(),e);
        return null;
      }
    }
    /**
     * 查询二级分类
     */
    @PostMapping("queryCategoryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryCategoryListById(@RequestBody SubjectCategoryBO subjectCategoryBO) {
        try {
            List<SubjectCategoryBO> subjectCategoryBoList = subjectCategoryDomainService.queryCategoryListById(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategory(subjectCategoryBoList);
            return  Result.success(subjectCategoryDTOList );
        }catch (Exception e){
            log.error("SubjectCategoryController.queryCategoryList.error:{}",e.getMessage(),e);
            return null;
        }
    }
    /**
     * 更新分类
     */
    @PostMapping("update")
    public Result<Boolean> updateSubjectCategory(@Valid @RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("更新分类，subjectCategoryDTO为：{}", JSON.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategory(subjectCategoryDTO);
            if (log.isInfoEnabled()) {
                log.info("更新分类，subjectCategoryBO为：{}", JSON.toJSONString(subjectCategoryBO));
            }
            subjectCategoryDomainService.updateSubjectCategory(subjectCategoryBO);
            return Result.success(true);
        }catch (Exception e){
            log.error("SubjectCategoryController.update.error:{}",e.getMessage(),e);
            return Result.fail(false);
        }
    }
    /**
     * 删除分类
     */
    @PostMapping("delete")
    public Result<Boolean> deleteSubjectCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            boolean result = subjectCategoryDomainService.deleteById(subjectCategoryDTO.getId());
            return Result.success(result);
        }catch (Exception e){
            log.error("SubjectCategoryController.delete.error:{}",e.getMessage(),e);
            return Result.fail(false);
        }
    }

}
