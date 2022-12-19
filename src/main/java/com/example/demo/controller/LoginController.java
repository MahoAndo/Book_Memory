
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * LoginController
 * @author maho ando
 * @date Oct 15 2022
 */
@Controller
public class LoginController{
	@Autowired
    private UserService userService;
    	
	/**
	 * showing login page
	 * @param type(0: login, 1:after registering, 2:error)
	 * @param model
	 * @return login
	 */
	@GetMapping("/user")
	public String start(@RequestParam(name = "type", required = false) Integer type, Model model) {
		
		model.addAttribute("user", new User());
		if(type == null)
			type = 0;
		
		model.addAttribute("type", type);
		model.addAttribute("maxNo", userService.getMaxNo());
		
		return "user/login";
	}
	
	/**
	 * checking username and password
	 * @param model
	 * @param user
	 * @return choose / login
	 */
	@RequestMapping(value = "/user")
	public String search(@ModelAttribute User user, Model model) {
		
		try {
				int userNo = userService.getUserNo(user.getUserName(), user.getPassword());
				model.addAttribute("user", user);
				model.addAttribute("userNo", userNo);
				if(userNo != 0)
					// go to choose page
					return "user/select";
				else 
					// go to admin page
					return "user/select";
			
		} catch (Exception e) {
			// back to login page
			return "redirect:user/?type=2";
		}
	}
}