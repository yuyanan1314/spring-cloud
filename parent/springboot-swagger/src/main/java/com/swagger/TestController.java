package com.swagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@Api("测试接口")
@RestController
public class TestController {

	@ApiOperation("test接口")
	@GetMapping("/a/test")
	public String test() {
		return "你好";
	}
	
	@ApiOperation("查询用户")
	@GetMapping("/user/get")
	public User get(@RequestParam String id) {
		return new User();
	}
	
	@ApiModel("用户信息")
	public static class User{
		@ApiModelProperty("用户名")
		private String name;
		@ApiModelProperty("密码")
		private String password;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
	}
}
