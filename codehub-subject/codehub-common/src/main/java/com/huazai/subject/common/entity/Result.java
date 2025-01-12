package com.huazai.subject.common.entity;

import com.huazai.subject.common.enums.ResultCode;
import lombok.Data;

@Data
public class Result<T> {

    private boolean success;

    private String message;

    private Integer code;

    private T data;

    public static Result success(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return result;
    }

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }
    public static Result fail(){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCode.FAIL.getCode());
        result.setMessage(ResultCode.FAIL.getMessage());
        return result;
    }
    public static <T> Result<T>  fail(T data){
        Result<T>  result = new Result<T> ();
        result.setSuccess(false);
        result.setCode(ResultCode.FAIL.getCode());
        result.setMessage(ResultCode.FAIL.getMessage());
        result.setData(data);
        return result;
    }
}
