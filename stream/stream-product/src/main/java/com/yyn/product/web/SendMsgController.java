package com.yyn.product.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyn.product.stream.SendMessageInterface;
import com.yyn.product.stream.User;

@RestController
public class SendMsgController {
	
	@Autowired
	private SendMessageInterface smsService;
	
	//默认以通道的名称创建路由键
	//生产者过程
	@RequestMapping("/sendMsg")
	public String  sendMsg() {
		User u = new User();
		u.setAge("12");
		u.setUsername("admin");
		String msg = UUID.randomUUID().toString();
		System.out.println(msg);
		Message<User> build = MessageBuilder.withPayload(u).build();
		smsService.sendMsg().send(build);
		return "success";
	}
	
}
