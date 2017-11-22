package com.oddle.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.oddle.app.configuration.HibernateConfiguration;

@Import(HibernateConfiguration.class)
@SpringBootApplication(scanBasePackages = { "com.oddle.app" })
public class WeatherAppBoilerPlateApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WeatherAppBoilerPlateApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppBoilerPlateApplication.class, args);
	}
}
