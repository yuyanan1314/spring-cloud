package com.order;

import lombok.Data;

@Data
public class Order {

    private Integer id;
    private String name;
    private String password;
    private String phone;

	//省略 get 和 set ...
}
