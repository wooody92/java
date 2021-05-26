package dev.effective.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EffectiveJavaApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EffectiveJavaApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}
}
