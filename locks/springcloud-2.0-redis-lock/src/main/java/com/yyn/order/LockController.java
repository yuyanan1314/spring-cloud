package com.yyn.order;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LockController {

    @CacheLock(prefix = "test")
    @GetMapping("/test")
    public String query(@CacheParam(name = "token") @RequestParam String token) {
    	try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success - " + token;
    }

   
    
}