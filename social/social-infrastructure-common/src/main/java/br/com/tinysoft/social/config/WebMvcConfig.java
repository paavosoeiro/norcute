package br.com.tinysoft.social.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.tinysoft.social.security.ProfileRequestInterceptor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
//		registry.addWebRequestInterceptor(new ProfileRequestInterceptor());
	}
	
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		super.configureViewResolvers(registry);
//		System.out.println("Add tiles view resolver");
//		TilesView tiles = new TilesView();
//		MappingJackson2JsonView view = new MappingJackson2JsonView();
//		view.setContentType("text/*");
//		registry.enableContentNegotiation(view);
//	}
	
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		MappingJackson2HttpMessageConverter converter2 = new MappingJackson2HttpMessageConverter();
		converter2.setObjectMapper(mapper);
		converters.add(converter2);
		addDefaultHttpMessageConverters(converters);
	}
	
	
}