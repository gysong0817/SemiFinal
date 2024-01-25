package com.miniproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miniproject.dto.UserDTO;
import com.miniproject.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userId, String password, HttpSession session) {
		String view = "error";
		UserDTO user = null;
		
		user = userService.getUserByUserId(userId);
		System.out.println(user);
		
		if(user != null && user.getPassword().equals(password)) {
			session.setAttribute("userId", user.getUserId());
			
			view = "redirect:/main";
			return view;
		}
		
		return view;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		
		return "redirect:/main";
	}
	
}
