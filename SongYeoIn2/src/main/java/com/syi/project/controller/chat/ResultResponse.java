package com.syi.project.controller.chat;

import lombok.Data;

@Data
public class ResultResponse<T> {

    private boolean success;
    private String message;
    private T data;

    // 기본 생성자
    public ResultResponse() {}

    // 생성자
    public ResultResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // 정적 메서드
    public static <T> ResultResponse<T> of(boolean success, String message, T data) {
        return new ResultResponse<>(success, message, data);
    }
	
}
