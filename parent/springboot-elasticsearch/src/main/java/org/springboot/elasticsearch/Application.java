package org.springboot.elasticsearch;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
@EnableElasticsearchRepositories("org.springboot.ealsticsearch")
public class Application {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("add")
	public void add(String id) {
		User user = new User();
		user.setId(id);
		user.setName("yyn" + id);
		user.setAge(18);
		user.setSex(1);
		userDao.save(user);
	}
	
	@RequestMapping("get")
	public Optional<User> get(String id) {
		return userDao.findById(id);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

