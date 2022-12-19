
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * RegisterController
 * @author maho ando
 * @date Oct 15 2022
 */
@Controller
public class RegisterController{
	@Autowired
	private UserService userService;
	
	/**
	 * showing register page
	 * @param model Model
	 * @return register page
	 */
	@GetMapping("/user/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "user/register";
	}
	
	/**
	 * register user
	 * @param model Model
	 * @return login page
	 */
	@RequestMapping("/user/register")
	public String insertUser(@ModelAttribute User user, Model model) {
		
		userService.insertUser(user);
		
		// back to login page
		return "redirect:/user/?type=1";
	}
}