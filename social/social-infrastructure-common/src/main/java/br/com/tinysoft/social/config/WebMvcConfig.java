package br.com.tinysoft.social.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.tinysoft.social.security.ProfileRequestInterceptor;


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter  {//  WebMvcConfigurationSupport {
	
	public void addInterceptors(InterceptorRegistry registry) {
//		super.addInterceptors(registry);
		System.out.println("interceptor	");
		registry.addWebRequestInterceptor(new ProfileRequestInterceptor());
	}
}