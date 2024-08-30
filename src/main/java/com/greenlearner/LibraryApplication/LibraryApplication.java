package com.greenlearner.LibraryApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import java.io.Serializable;

@SpringBootApplication
@EnableCaching
public class LibraryApplication implements Serializable{

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
