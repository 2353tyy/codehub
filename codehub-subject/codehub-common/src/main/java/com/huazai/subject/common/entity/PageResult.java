package com.huazai.subject.common.entity;

import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页结果
 *
 * @author huazai
 */
@Data
public class PageResult<T> implements Serializable {

    @Setter
    private Integer pageNo = 1;
    @Setter
    private Integer pageSize = 20;
    private Integer total = 0;
    private Integer totalPage = 0;
    private List<T> result = Collections.emptyList();
    private Integer start = 1;
    private Integer end = 0;

    public void setRecords(List<T> result){
        this.result = result;
        if (result != null && result.size() > 0){
            setTotal(result.size());
        }
    }

    public void setTotal(int size) {
        this.total = size;
        if (this.pageSize > 0){
            this.totalPage = (total / this.pageSize) + (total % this.pageSize == 0 ? 0 : 1);
        }else{
            this.totalPage = 0;
        }
        this.start = (this.pageNo > 0 ? (this.pageNo - 1) * this.pageSize : 0) + 1;
        this.end = (this.start - 1 + this.pageSize * (this.pageSize > 0 ? 1 : 0 ));
    }

}
