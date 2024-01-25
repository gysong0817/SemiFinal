package com.miniproject.mapper;

import javax.swing.text.AbstractDocument.Content;

import org.apache.ibatis.annotations.Mapper;

import com.miniproject.dto.CommentDTO;

@Mapper
public interface CommentMapper {
	
	
	//댓글 등록
	public int insertconmment(CommentDTO comment);
	
	//댓글 수정
	public String updateComment(Content content);
	
	
	//댓글 삭제
	public int deleteComment(int commentNo);

	
	


	
	
	

}
