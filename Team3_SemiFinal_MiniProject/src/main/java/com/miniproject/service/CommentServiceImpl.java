package com.miniproject.service;

import javax.swing.text.AbstractDocument.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.dto.CommentDTO;
import com.miniproject.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper mapper;
	
	//댓글 등록
	@Override
	public int insertConmment(CommentDTO comment) {
		
		return mapper.insertconmment(comment);
	}
	
	//댓글 수정
	
	@Override
	public String updateComment(Content content) {
		return mapper.updateComment(content);
	}
	
	//댓글 삭제
	@Override
	public int deleteComment(int commentNo) {
		return mapper.deleteComment(commentNo);
	}

	
}