
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * LoginController
 * @author maho ando
 * @date Nov 8 2022
 */
@Controller
public class SelectController{

	/**
	 * showing select page
	 * @param userNo
	 * @param model
	 * @return select
	 */
	@GetMapping("/user/select")
	public String select(@RequestParam(name = "userNo") Integer userNo, Model model) {
		
		model.addAttribute("userNo", userNo);
		
		return "user/select";
	}
}