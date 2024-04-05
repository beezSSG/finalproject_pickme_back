package com.pickme.beeze;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PickmeApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(PickmeApplication.class)
					.properties(PROPERTIES)
					.run(args);
	}
	
	private static final String PROPERTIES = 
	        "spring.config.location="
	        +"classpath:/application.properties"
	        +",classpath:/db.properties"
	        +",classpath:/key.properties"
	        +",classpath:/mail.yml";
	        
	
//	public static void main(String[] args) {
//		SpringApplication.run(PickmeApplication.class, args)
//	}

}