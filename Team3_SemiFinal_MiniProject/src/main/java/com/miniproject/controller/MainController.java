package com.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miniproject.dto.BoardDTO;
import com.miniproject.service.BoardService;

@Controller
public class MainController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String getAllBoard(Model model) {
		
		List<BoardDTO> boardList = service.getAllBoard();
		model.addAttribute("boardList", boardList);
		
		System.out.println(boardList);
		return "main";
	}
}
