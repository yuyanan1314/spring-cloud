package com.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

/**
 * 限流配置
 *
 * @author yuyanan01@beyondsoft.com
 * @version 1.0
 * @date 19-1-28
 */
@Configuration
public class KeyResolverConfigurator {
	
	/**
	 * 根据ip地址限制流量
	 */
	@Bean
	public KeyResolver ipKeyResolver() {
	    return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
	}
	
//	/**
//	 * 根据用户限流
//	 */
//	@Bean
//	public KeyResolver userKeyResolver() {
//	    return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("appId"));
//	}
//	
//	/**
//	 * 根据url进行限流
//	 * @return
//	 */
//	@Bean
//	public KeyResolver apiKeyResolver() {
//	    return exchange -> Mono.just(exchange.getRequest().getPath().value());
//	}
}
