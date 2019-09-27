package com.skilldrive.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages = "com.skilldrive")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringbootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootappApplication.class, args);
	}

}
