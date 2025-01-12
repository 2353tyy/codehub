package com.huazai.subject.common.enums;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(200, "成功"),
    FAIL(400, "失败"),
    UNAUTHORIZED(401, "未认证"),
    NOT_FOUND(404, "接口不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public static ResultCode getByCode(Integer codeVal) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.code.equals(codeVal)) {
                return resultCode;
            }
        }
        return null;
    }

}
