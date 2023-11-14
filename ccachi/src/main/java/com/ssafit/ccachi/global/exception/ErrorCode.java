package com.ssafit.ccachi.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    //400 BAD_REQUEST 잘못된 요청
    INVALID_PARAMETER(400, "파라미터 값을 확인해주세요."),
    WRONG_PASSWORD(400, "password 값을 확인해주세요."),

    //404 NOT_FOUND 잘못된 리소스 접근
    DISPLAY_NOT_FOUND(404, "존재하지 않는 전시회 ID 입니다."),

    //409 CONFLICT 중복된 리소스
    ALREADY_SAVED_DISPLAY(409, "이미 저장한 전시회입니다."),

    //500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, "서버 에러입니다. 서버 팀에 연락주세요!");

    private final int status;
    private final String message;
}