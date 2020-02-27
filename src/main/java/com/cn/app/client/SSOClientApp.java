package com.cn.app.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class SSOClientApp {
	  public static void main(String[] args) {
	        SpringApplication.run(SSOClientApp.class, args);
	    }

	  @Value("${test}")
	  public String test;
	  
	  @RequestMapping("/test")
	  public String test() {
		  return test;
	  }
}
