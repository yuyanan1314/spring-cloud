package com.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingapi.tx.annotation.TxTransaction;

@Service
public class OrderService {
	
	@Autowired
	private OrderMapper userMapper;
	
	@Transactional
	public void add() {
		userMapper.insert("admin", "admin", "12345");
	}
}
