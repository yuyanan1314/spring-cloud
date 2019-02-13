package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * gateway 启动入口
 *
 * @author yuyanan01@beyondsoft.com
 * @version 1.0
 * @date 19-1-28
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateWayApplication.class, args);
	}
	
}

