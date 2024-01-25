package com.miniproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miniproject.dto.CommentDTO;
import com.miniproject.dto.UserDTO;
import com.miniproject.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	@ResponseBody
	@RequestMapping("/list")
	public ArrayList<CommentDTO> CommentList(@RequestParam("boardNo")int boardNo, Model model){
		return service.CommentList(boardNo);
		
	}
	
	
	@GetMapping("insert")
	public String insertComment(@RequestParam("boardNo")int boardNo , Model model) {
		model.addAttribute("boardNo", boardNo);
		return "Boardview";
		
	}
	
	@ResponseBody
	@PostMapping("insert")
	public String PostInsertComent(CommentDTO dto, HttpSession session,Model model) {
		UserDTO tmp=(UserDTO) session.getAttribute("userId");
		dto.setUserId(tmp.getUserId());
		
		return service.insertComment(dto);
	}
	
	@GetMapping("update")
	public String updateComment(CommentDTO dto) {
		System.out.println(dto.getCommentNo());
		System.out.println(dto.getContent());
		 service.updateComment(dto);	
		return "Member/Comment/insert";
	}
	
	@ResponseBody
	@PostMapping("update")
	public String PostUpdateComment(CommentDTO dto) {
		return service.updateComment(dto);
	}
	
	@ResponseBody
	@PostMapping("delete")
	public String deleteComment(@RequestParam("CommentNo")int CommentNo) {
		
		return service.deleteComment(CommentNo);
	}
	
}