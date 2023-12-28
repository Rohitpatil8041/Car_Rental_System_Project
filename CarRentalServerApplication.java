package com.ecity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class,MailSenderAutoConfiguration.class })
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
//@EnableAutoConfiguration(exclude =  MailSenderAutoConfiguration.class)

@SpringBootApplication
public class CarRentalServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalServerApplication.class, args);
	}

}
