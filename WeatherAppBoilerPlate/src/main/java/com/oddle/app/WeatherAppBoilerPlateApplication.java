package com.oddle.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.oddle.app.configuration.HibernateConfiguration;

@Import(HibernateConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.oddle.app"})
public class WeatherAppBoilerPlateApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppBoilerPlateApplication.class, args);
	}
}
