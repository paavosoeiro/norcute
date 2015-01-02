package br.com.tinysoft.social.security;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;


@Component
public class ProfileRequestInterceptor implements WebRequestInterceptor {
	
	public void preHandle(WebRequest request) throws Exception {
		System.out.println("Pre handle");
	}

	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		System.out.println("Post Handle");
	}

	public void afterCompletion(WebRequest request, Exception ex)
			throws Exception {
		System.out.println("after Completion");
	}
}
