package com.ruinivan.edufincore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EduFinCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduFinCoreApplication.class, args);
	}

}
