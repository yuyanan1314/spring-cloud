package com.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingapi.tx.annotation.TxTransaction;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class Application {
	
	@Autowired
	private Imember member;
	
	@Autowired
	private OrderService service;
	
	@GetMapping("/add")
	@TxTransaction(isStart = true)
	@Transactional
	public String add(Integer m) {
		//添加订单
		service.add();
		
		//添加会员
		 member.add();
		 int a = 1/m;
		 return "success";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@FeignClient(value="lcn-member")
	public static interface Imember{
		
		@GetMapping("/add")
		String add();
	}
}

