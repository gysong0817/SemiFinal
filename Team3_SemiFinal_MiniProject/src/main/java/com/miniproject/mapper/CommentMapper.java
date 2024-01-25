package com.miniproject.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.miniproject.dto.CommentDTO;

@Mapper
public interface CommentMapper {

	public ArrayList<CommentDTO> CommentList(int boardNo);

	public boolean insertComment(CommentDTO dto);

	public boolean updateComment(CommentDTO dto);

	public void deleteComment(int commentNo);


}