package com.ssafit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("/api/data")
    public String test(){
        return "연결 성공!";
    }
}
