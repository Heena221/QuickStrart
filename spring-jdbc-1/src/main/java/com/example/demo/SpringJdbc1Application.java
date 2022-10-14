package com.example.demo;

//import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.services.CustomerServices;

@SpringBootApplication
public class SpringJdbc1Application {
	
	public static void addData() {
		
	}

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx= SpringApplication.run(SpringJdbc1Application.class, args);
	int key=2;
	CustomerServices service=ctx.getBean(CustomerServices.class);
	if(key==1) {
	
	
	Customer obj=ctx.getBean(Customer.class);
	//obj={0,null,null}
	obj.setCustomerId(Integer.parseInt(args[1]));
	obj.setCustomerName(args[2]);
	obj.setEmail(args[3]);
	//obj here {101,heen,abc@mail}
	
	System.out.println("Is Added:="+service.save(obj));
	}
	if(key==2) {
		service.findAll().forEach(System.out::println);
	}
	ctx.close();
	
	
	}

}
