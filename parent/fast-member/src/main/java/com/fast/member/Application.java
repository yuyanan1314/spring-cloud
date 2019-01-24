package com.fast.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fast.member.stomp.SocketResponse;
import com.fast.member.stomp.SocketTool;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
@EnableSwagger2
@Api("会员接口服务")
public class Application {
	
	@Value("${server.port}")
	private String port;
	
	@ApiOperation("获取会员信息")
	@GetMapping("/getMember")
	public String getMember() {
		return "我是会员服务" + port;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private SocketTool socketTool;
	
	@GetMapping("/test")
	public void test() {
		SocketResponse sr = new SocketResponse();
		sr.setData("yuyanan");
		socketTool.sendToAll("/topic/guangbo", sr);
	}
}

