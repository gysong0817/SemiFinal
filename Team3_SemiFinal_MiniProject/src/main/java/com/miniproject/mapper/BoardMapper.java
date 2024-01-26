package com.miniproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.miniproject.dto.BoardDTO;
import com.miniproject.dto.UserDTO;

@Mapper
public interface BoardMapper {

	List<BoardDTO> getAllBoard();
	
	BoardDTO getBoardByBoardNo(int boardNo);

	int updateBoard(BoardDTO board);
	
	int createBoard(BoardDTO boardDTO);
	
	int deleteBoardByBoradNo(int boardNo);

	UserDTO getUserByUserId(String userId);

	
}
