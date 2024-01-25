package com.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.dto.BoardDTO;
import com.miniproject.dto.PageRequestDTO;
import com.miniproject.mapper.MainMapper;

@Service
public class MainService {
	
	@Autowired
	MainMapper mapper;

	public List<BoardDTO> getBoardBySearchKeyword(String searchKeyword) {
		List<BoardDTO> boardList = null;
		
		boardList = mapper.getBoardBySearchKeyword(searchKeyword);
		
		return boardList;
	}

	public List<BoardDTO> getBoardBySeachWithPage(PageRequestDTO pageRequest) {
		List<BoardDTO> boardList = null;
		
		boardList = mapper.getBoardBySeachWithPage(pageRequest);
		
		return boardList;
	}

	public int getTotalCount(PageRequestDTO pageRequest) {
		int res = mapper.getTotalCount(pageRequest);
		
		return res;
	}
	
}
