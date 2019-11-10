package com.ayya.sport;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import com.ayya.sport.entity.Client;
import com.ayya.sport.repository.ClientRepository;

@SpringBootApplication
public class Application{
@Autowired
ClientRepository clientRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		// System.out.println(Paths.get("classpath:img").toAbsolutePath().toString());
	}
	
	
	 

}
