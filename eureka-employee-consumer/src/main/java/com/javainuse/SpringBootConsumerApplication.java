package com.javainuse;

import java.io.IOException;

import com.javainuse.controllers.EmpConsumerControllerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;


@SpringBootApplication
public class SpringBootConsumerApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(
				SpringBootConsumerApplication.class, args);
		
		EmpConsumerControllerClient consumerControllerClient=ctx.getBean(EmpConsumerControllerClient.class);
		System.out.println(consumerControllerClient);
		consumerControllerClient.getEmployee();
		
	}
	
	/*@Bean
	public  EmpConsumerControllerClient  empConsumerControllerClient()
	{
		return  new EmpConsumerControllerClient();
	}*/
}
