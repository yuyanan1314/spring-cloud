package org.zipkin.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class Application {
	
	@Autowired
	private Imember member;
	
	
	@GetMapping("/getOrder")
	public String getMember() {
		return member.getMember();
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

