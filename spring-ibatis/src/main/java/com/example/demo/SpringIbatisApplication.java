package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Customer;
import com.example.demo.services.CustomerServices;

@SpringBootApplication
public class SpringIbatisApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(SpringIbatisApplication.class, args);
	ctx.getBean(CustomerServices.class).findAll().forEach(System.out::println);
	Customer obj=ctx.getBean(Customer.class);
	//obj={0,null,null}
	obj.setCustomerId(7890);
	obj.setCustomerName("Achii");
	obj.setEmail("Achii@abc.com");
	CustomerServices service=ctx.getBean(CustomerServices.class);
	System.out.println("Is Added:= "+service.save(obj));
	ctx.close();
	}

}
