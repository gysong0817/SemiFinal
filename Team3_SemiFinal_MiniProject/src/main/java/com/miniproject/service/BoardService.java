package com.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.dto.BoardDTO;
import com.miniproject.exception.BoardDeleteException;
import com.miniproject.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	BoardMapper mapper;

	public List<BoardDTO> getAllBoard() {
		List<BoardDTO> boardList = mapper.getAllBoard();
		return boardList;
	}

	public BoardDTO getBoardByBoardNo(int boardNo) {
		BoardDTO board = mapper.getBoardByBoardNo(boardNo);
		return board;
	}
	
	public void createBoard(BoardDTO boardDTO) {
		mapper.insertBoard(boardDTO);
	}
	
	public boolean updateBoard(BoardDTO board) {
	    int res = mapper.updateBoard(board);
	    return res != 0;
	}

	public void deleteBoardByBoradNo(int boardNo) {
		int res = mapper.deleteBoardByBoradNo(boardNo);

		if (res == 0) {
			throw new BoardDeleteException("게시물 삭제에 실패했습니다.");
		}
	}
}

