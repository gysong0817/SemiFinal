package com.miniproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miniproject.dto.UserDTO;
import com.miniproject.service.UserService;

@Controller
public class JoinController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String userJoinForm() {
		return "join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView userJoin(UserDTO newUser) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView();
		boolean result = userService.insertUser(newUser);
		
		if(result) {
			mav.setViewName("main");
		} else {
			mav.setViewName("error");
		}
		
		return mav;
	}
}
