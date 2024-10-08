package com.wsu.workorderproservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication annotation is used to mark a configuration class that declares one or more @Bean methods,
// and also triggers auto-configuration and component scanning.
@SpringBootApplication
public class WorkOrderProServiceApplication {

	/**
	 * SpringBoot Starter method on embedded tomcat server
	 * @param args - Allow to pass String array JVM arguments to set value dynamically during runtime
	 */
	public static void main(String[] args) {
		SpringApplication.run(WorkOrderProServiceApplication.class, args);
	}

}
