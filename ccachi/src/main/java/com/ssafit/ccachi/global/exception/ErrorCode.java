package com.ssafit.ccachi.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    //400 BAD_REQUEST 잘못된 요청
    INVALID_PARAMETER(400, "파라미터 값을 확인해주세요."),
    WRONG_PASSWORD(400, "password 값을 확인해주세요."),
    WRONG_USER_ID(400,"user Id와 일치하는 user가 없습니다."),
    WRONG_EMAIL(400,"email이 일치하는 user가 없습니다."),

    //404 NOT_FOUND 잘못된 리소스 접근

    //409 CONFLICT 중복된 리소스

    //500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, "서버 에러입니다. 서버 팀에 연락주세요!");

    private final int status;
    private final String message;
}