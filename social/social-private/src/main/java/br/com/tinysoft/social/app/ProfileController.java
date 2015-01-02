package br.com.tinysoft.social.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.tinysoft.social.persistence.User;

@Controller
public class ProfileController {
	
//	@Autowired
//	private UserRepository userRepository;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "hi!";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	@ResponseBody
	public User insert(HttpServletRequest request) {
		System.out.println("create");
		User user = new User();
		user.setUid("aaappp");
		user.setLogin("marllon");
		user.setNome("marllon");
//		userRepository.insert(user);
		
		return user;
		
	}
}
