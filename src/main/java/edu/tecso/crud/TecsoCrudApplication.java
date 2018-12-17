package edu.tecso.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"edu.tecso.crud"})
@EnableJpaRepositories("edu.tecso.crud.repository")
@EntityScan("edu.tecso.crud.model")
public class TecsoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TecsoCrudApplication.class, args);
	}
	
}
