package com.miniproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miniproject.dto.UserDTO;
import com.miniproject.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

	// getUserNoByUserId (userId를 입력받아 userNo를 반환)
	public int getUserNoByUserId(@PathVariable String userId) {
		int userNo = 0;
		
		userNo = service.getUserNoByUserId(userId);

		return userNo;
	}

	// getUserByUserId
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public String getUserByUserId(@PathVariable String userId, Model model) {
		UserDTO user = null;

		user = service.getUserByUserId(userId);
		model.addAttribute("user", user);

		return "userDetail";
	}

	// InsertUser
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String insertUserForm() {
		return "registerUser";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute UserDTO newUser) {
		String view = "error";
		boolean result = false;

		result = service.insertUser(newUser);

		if (result) {
			view = "redirect:/main";
			return view;
		}

		return view;
	}

	// UpdateUser
	@RequestMapping(value = "/modify/user/{userNo}", method = RequestMethod.GET)
	public String updateUserForm(@PathVariable String userId, Model model) {

		UserDTO user = service.getUserByUserId(userId);
		model.addAttribute("user", user);

		return "updateUser";
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable String userId, @ModelAttribute UserDTO newUser) {
		String view = "error";

		UserDTO user = null;
		boolean result = false;

		user = service.getUserByUserId(userId);

		user.setUserId(newUser.getUserId());
		user.setName(newUser.getName());
		user.setGender(newUser.getGender());
		user.setPhone(newUser.getPhone());

		result = service.updateUser(user);

		return view;
	}

	// DeleteUser
	@RequestMapping(value = "/user/{userNo}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable int userNo) {
		String view = "error";
		boolean result = false;

		result = service.deleteUser(userNo);

		if (result) {
			view = "redirect:/main";
			return view;
		}

		return view;
	}

}
