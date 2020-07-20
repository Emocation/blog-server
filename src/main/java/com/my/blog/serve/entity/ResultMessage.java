package com.my.blog.serve.entity;

/**
 * @Author: jiangkaibing
 * @Date: Create in 15:50 2020/7/19
 */
public class ResultMessage<T> {
    Integer code;
    String message;
    T data;

    public ResultMessage() {
    }

    public ResultMessage(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
