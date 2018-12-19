package com.yyn.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;


public interface SendMessageInterface {
	
	//创建消息发送通道
	@Input("my_stream_channel")
	SubscribableChannel sendMsg();
}
