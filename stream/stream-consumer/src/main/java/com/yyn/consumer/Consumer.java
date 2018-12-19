package com.yyn.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@Value("${server.port}")
	private String port;
	
	@StreamListener("my_stream_channel")
	public void msg(User msg) {
		System.out.println("消费者" + port + "" + msg.toString());
	}
}
