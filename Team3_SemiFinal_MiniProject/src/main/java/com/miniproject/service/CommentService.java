package com.miniproject.service;

import javax.swing.text.AbstractDocument.Content;

import com.miniproject.dto.CommentDTO;

public interface CommentService {
	//댓글등록
	int insertConmment(CommentDTO comment);
	
	//댓글 수정
	String updateComment(Content content);
	
	//댓글 삭제
	int deleteComment(int commentNo);


}
