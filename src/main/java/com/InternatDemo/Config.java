package com.InternatDemo;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class Config extends WebMvcConfigurerAdapter{

	@Bean
	public SessionLocaleResolver  localeResolver() {
	   SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
	   sessionLocaleResolver.setDefaultLocale(Locale.US);
	   return sessionLocaleResolver;
	}
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	   LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	   localeChangeInterceptor.setParamName("language");
	   return localeChangeInterceptor;
	}
	public void addInterceptors(InterceptorRegistry registry) {
	   registry.addInterceptor(localeChangeInterceptor());
	}
}
