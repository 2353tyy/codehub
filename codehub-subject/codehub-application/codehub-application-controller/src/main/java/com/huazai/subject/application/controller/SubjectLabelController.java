package com.huazai.subject.application.controller;


import com.huazai.subject.application.convert.SubjectLabelDTOConverter;
import com.huazai.subject.application.dto.SubjectLabelDTO;
import com.huazai.subject.common.entity.Result;
import com.huazai.subject.domain.entity.SubjectLabelBO;
import com.huazai.subject.domain.service.SubjectLabelDomainService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {
    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 查询分类下标签
     */
    @PostMapping("queryLabelByCategoryId")
    public Result<List<SubjectLabelDTO>> queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE
                    .convertDtoToBo(subjectLabelDTO);
            List<SubjectLabelBO> subjectLabelBOList = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBO);
            List<SubjectLabelDTO> subjectLabelDTOList =SubjectLabelDTOConverter.INSTANCE
                    .convertBoToDto(subjectLabelBOList);;
            return Result.success(subjectLabelDTOList);
        }catch (Exception e){
            log.error("SubjectCategoryController.queryCategoryList.error:{}",e.getMessage(),e);
            return null;
        }
    }

    /**
     * 新增分类
     */
    @PostMapping("add")
    public Result<Boolean> addSubjectLabel(@Valid @RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.
                    convertDtoToBo(subjectLabelDTO);
            subjectLabelDomainService.addSubjectLabel(subjectLabelBO);
            return Result.success(true);
        }catch (Exception e){
            log.error("SubjectCategoryController.add.error:{}",e.getMessage(),e);
            return Result.fail(false);
        }
    }
    /**
     * 更新分类
     */
    @PostMapping("update")
    public Result<Boolean> updateSubjectCategory(@Valid @RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE
                    .convertDtoToBo(subjectLabelDTO);
            subjectLabelDomainService.updateSubjectLabel(subjectLabelBO);
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
    public Result<Boolean> deleteSubjectCategory(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            boolean result = subjectLabelDomainService.deleteById(subjectLabelDTO.getId());
            return Result.success(result);
        }catch (Exception e){
            log.error("SubjectCategoryController.delete.error:{}",e.getMessage(),e);
            return Result.fail(false);
        }
    }
}
