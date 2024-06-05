package com.ojt.first.dto.response;

/**
 * JSON 형식의 Response에 반드시 들어가야하는 항목
 * code와 message만 들어갈 경우 생성자로 객체를 생성
 */
public class BaseResponse {

    private String code;
    private String message;

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
