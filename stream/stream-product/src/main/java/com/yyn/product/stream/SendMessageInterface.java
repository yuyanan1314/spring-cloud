package com.yyn.product.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;


public interface SendMessageInterface {
	
	//创建消息发送通道
	@Output("my_stream_channel")
	SubscribableChannel sendMsg();
}
