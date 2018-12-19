package com.yyn.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.yyn.product.stream.SendMessageInterface;

@SpringBootApplication
@EnableBinding(SendMessageInterface.class)
public class StreamProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamProductApplication.class, args);
	}

}

