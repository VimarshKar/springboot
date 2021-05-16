package com.vimarsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class VimApplication {

	public static void main(String[] args) {
		SpringApplication.run(VimApplication.class, args);
	}

}
