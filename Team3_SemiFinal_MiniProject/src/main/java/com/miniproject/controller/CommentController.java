package com.miniproject.controller;


import javax.swing.text.AbstractDocument.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.dto.CommentDTO;
import com.miniproject.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	//댓글 삽입
	@PostMapping("/comment")
	public int insertConmment(@RequestBody CommentDTO comment) {
		return service.insertConmment(comment);
		
	}

	
	//댓글 수정
	@PostMapping("comment/update")
	public String updateComment(@RequestBody Content content) {
		return service.updateComment(content);
		
	}
	
	//댓글 삭제-
	@GetMapping("/comment/delete")
	public int deleteComment(int commentNo) {
		return service.deleteComment(commentNo);
		
	}

}
