package com.elephant.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 基本响应结果
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
@Data
@AllArgsConstructor
public class BaseResult<R> {

    private Integer code;
    private String message;
    private R r;

    public static <R> BaseResult<R> success() {
        return custom(200, null, null);
    }

    public static <R> BaseResult<R> success(String message) {
        return custom(200, message, null);
    }

    public static <R> BaseResult<R> success(R r) {
        return custom(200, null, r);
    }

    public static <R> BaseResult<R> success(String message, R r) {
        return custom(200, message, r);
    }

    public static <R> BaseResult<R> fail() {
        return custom(500, "系统繁忙，请稍后再试", null);
    }

    public static <R> BaseResult<R> fail(String message) {
        return custom(500, message, null);
    }

    public static <R> BaseResult<R> fail(String message, R r) {
        return custom(500, message, r);
    }

    private static <R> BaseResult<R> custom(Integer code, String message, R r) {
        return new BaseResult<>(code, message, r);
    }
}
