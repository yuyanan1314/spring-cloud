package org.springboot.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Document(indexName = "yyn", type = "user")
@Data
public class User {
	
	@Id
	private String id;
	private String name;
	private Integer age;
	private Integer sex;
}
