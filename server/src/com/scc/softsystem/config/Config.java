package com.scc.softsystem.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module.Feature;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.scc.softsystem")
@Import(HibernateConfiguration.class)
public class Config extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver viewResolver()
	{
		return new BeanNameViewResolver();
	}
	
	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

		ObjectMapper mapper = new ObjectMapper();
		Hibernate5Module module = new Hibernate5Module();
		module.configure(Feature.FORCE_LAZY_LOADING, false)
			  .configure(Feature.USE_TRANSIENT_ANNOTATION, false);
		mapper.registerModule(module);

		messageConverter.setObjectMapper(mapper);
		return messageConverter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(jacksonMessageConverter());
		super.configureMessageConverters(converters);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://localhost:80","http://localhost","http://localhost:8080");
	}
}
