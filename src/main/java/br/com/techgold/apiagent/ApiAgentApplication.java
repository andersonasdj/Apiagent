package br.com.techgold.apiagent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true)
@EnableScheduling
public class ApiAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAgentApplication.class, args);
	}

}
