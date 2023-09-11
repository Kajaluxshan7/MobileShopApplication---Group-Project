package com.group02.mobileshopsystem.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaRepositories
@SpringBootApplication
public class MobileShopApp {

	public static void main(String[] args) {
		SpringApplication.run(MobileShopApp.class, args);
	}

}
