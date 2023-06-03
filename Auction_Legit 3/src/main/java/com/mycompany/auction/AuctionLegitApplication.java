package com.mycompany.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mycompany.auction")
public class AuctionLegitApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuctionLegitApplication.class, args);
	}

}
