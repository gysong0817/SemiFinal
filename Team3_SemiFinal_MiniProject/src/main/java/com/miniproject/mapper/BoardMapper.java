package com.miniproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.miniproject.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	List<BoardDTO> getAllBoard();
	
	BoardDTO getBoardByBoardNo(int boardNo);

	int updateBoard(BoardDTO board);
	
	void insertBoard(BoardDTO boardDTO);
	
	int deleteBoardByBoradNo(int boardNo);

	
}
