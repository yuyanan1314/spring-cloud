package com.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class Application {
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private UserService service;
	
	@GetMapping("/add")
	public String getMember() {
		service.add();
		return "我是会员服务" + port;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

