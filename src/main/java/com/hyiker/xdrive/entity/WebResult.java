package com.hyiker.xdrive.entity;

/**
 * 由sidhch于2018/4/5创建
 */

public class WebResult<T> {
    private Boolean success;
    private T object;
    private String message;

    public WebResult() {
    }

    public WebResult(Boolean success, T object, String message) {
        this.success = success;
        this.object = object;
        this.message = message;
    }

    public WebResult(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
