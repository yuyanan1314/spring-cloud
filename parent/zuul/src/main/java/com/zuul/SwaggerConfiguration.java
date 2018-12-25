package com.zuul;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Component
	@Primary
	class DocumentationConfig implements SwaggerResourcesProvider {

		@Override
		public List<SwaggerResource> get() {
			List<SwaggerResource> resource = new ArrayList<>();
			resource.add(swaggerResource("会员服务", "/api-member/v2/api-docs", "2.0"));
			resource.add(swaggerResource("订单服务", "/api-order/v2/api-docs", "2.0"));
			return resource;
		}
		
		private SwaggerResource swaggerResource(String name, String location, String version) {
			SwaggerResource sr = new SwaggerResource();
			sr.setName(name);
			sr.setLocation(location);
			sr.setSwaggerVersion(version);
			return sr;
		}
		
	}
}
