package com.miniproject.service;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miniproject.dto.CommentDTO;
import com.miniproject.mapper.CommentMapper;
@Service
public class CommentService {
	
	@Autowired
	private CommentMapper mapper;
	public ArrayList<CommentDTO> CommentList(int boardNo) {
		return mapper.CommentList(boardNo);
	}
	public String insertComment(CommentDTO dto) {
		
		if(dto.getContent()=="") {
			return "fail";
			
		}else if(mapper.insertComment(dto)) {
		
			return "success";
		}else {
			return "fail";
		}
	}
	public String updateComment(CommentDTO dto) {
		if(dto.getContent()=="") {
			return "fail";
		}else {
			mapper.updateComment(dto);
			return "success";
		
		}
	}
	public String deleteComment(int commentNo) {
		mapper.deleteComment(commentNo);
		return "success";
	}
	
}