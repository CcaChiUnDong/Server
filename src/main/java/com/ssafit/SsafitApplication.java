package com.ssafit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SsafitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsafitApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "Hello world Spring";
	}
}
