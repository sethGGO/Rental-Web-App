package com.myfinalyearproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.stripe.Stripe;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration. class })
public class WebAppApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		Stripe.apiKey = "sk_test_jBbyuMvm2Ws6ArjzJw96hdp9006KAu8y0T";
		SpringApplication.run(WebAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
