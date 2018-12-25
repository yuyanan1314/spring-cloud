package com.fast.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
@EnableSwagger2
@Api("会员订单接口")
public class Application {
	
	@Autowired
	private Imember member;
	
	@Value("${user.age}")
	private String age;
	
	@ApiOperation("获取订单信息")
	@GetMapping("/getOrder")
	public String getMember() {
		return member.getMember();
	}
	
	@ApiOperation("获取订单信息")
	@GetMapping("/getAge")
	public String getAge() {
		return age;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@FeignClient(value="yyn-member")
	public static interface Imember{
		
		@GetMapping("/getMember")
		String getMember();
	}
}

