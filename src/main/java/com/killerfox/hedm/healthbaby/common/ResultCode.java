package com.killerfox.hedm.healthbaby.common;

import com.alibaba.fastjson.JSONObject;


public enum ResultCode {

    SUCCESS(200, "成功"),

    BAD_REQUEST(400, "错误的请求"),
    NOT_FOUND(404, "不存在"),

    PARAM_IS_ERROR(410, "参数错误"),

    NOT_PERMISION(412, "不允许该操作"),

    ID_NOT_EXSIT(460, "不存在"),
    SERVER_ERROR(501, "内部服务异常，请联系管理员");


    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public String toJSONString() {

        JSONObject res = new JSONObject(true);
        res.put("code", this.code);
        res.put("message", this.message);
        return JSONObject.toJSONString(this);
    }

}
