package com.miniproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miniproject.dto.UserDTO;
import com.miniproject.service.UserService;

@Controller
public class OutController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/out", method = RequestMethod.GET)
	// 버튼을 통해 넘어왔기에 무조건 get post는 폼에서 post를 지정해줘야만 가능하다
	public ModelAndView userOut(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		int userNo = userService.getUserNoByUserId((String)session.getAttribute("userId"));
		
		boolean result = userService.deleteUser(userNo);
		
		if(result) {
			mav.setViewName("login");
		} else {
			mav.setViewName("error");
		}
		
		return mav;
	}
}
