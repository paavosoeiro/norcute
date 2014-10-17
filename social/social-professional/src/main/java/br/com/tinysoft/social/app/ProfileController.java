package br.com.tinysoft.social.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "hi!";
	}

}
