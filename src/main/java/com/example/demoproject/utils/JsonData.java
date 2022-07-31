package com.example.demoproject.utils;

public class JsonData {
    private int code;
    private Object data;
    private String msg;

    public JsonData() {
    }

    // 必须
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, "success");
    }

    public static JsonData buildSuccess(Object data, String msg) {
        return new JsonData(0, data, msg);
    }

    public static JsonData buildError(String msg) {
        return new JsonData(-1, null, msg);
    }

    public static JsonData buildError(int code, String msg) {
        return new JsonData(code, null, msg);
    }

    public static JsonData buildError(int code, Object data, String msg) {
        return new JsonData(code, data, msg);
    }


}
