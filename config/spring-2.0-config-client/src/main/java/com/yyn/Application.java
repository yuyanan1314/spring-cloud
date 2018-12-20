package com.yyn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class Application {
	
	@Value("${yyn.name}")
	private String yynName;
	
	@RequestMapping("/get")
	public String get() {
		return yynName;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


