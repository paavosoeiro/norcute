package br.com.tinysoft.social.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.tinysoft.social.persistence.User;
import br.com.tinysoft.social.persistence.repository.UserRepository;

@Controller
public class ProfileController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "hi!";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public String insert(HttpServletRequest request, @RequestBody User user) {
		System.out.println("create");
//		userRepository.insert(user);
		return "hi!";
	}
}
