package com.oddle.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class FreemakerConfigration {

	@Bean(name = "freemarkerConfig")
	public FreeMarkerConfigurer buildFreemarkerConfiguration() {
		FreeMarkerConfigurer bean = new FreeMarkerConfigurer();
		freemarker.template.Configuration config = new freemarker.template.Configuration();

		config.addAutoImport("layout", "base/layout/default.ftl");
		config.addAutoImport("app", "base/lib/app.ftl");
		bean.setDefaultEncoding("UTF-8");
		bean.setConfiguration(config);
		bean.getConfiguration().setClassForTemplateLoading(this.getClass(), "/templates/");

		return bean;
	}

	@Bean(name = "viewResolver")
	public FreeMarkerViewResolver viewResolver() {
		FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
		viewResolver.setExposeSpringMacroHelpers(true);
		viewResolver.setCache(false); // set true for production
		viewResolver.setSuffix(".ftl");
		viewResolver.setContentType("text/html; charset=UTF-8");
		return viewResolver;
	}
}
