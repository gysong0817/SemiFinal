package com.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.dto.BoardDTO;
import com.miniproject.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	BoardMapper mapper;

	public List<BoardDTO> getAllBoard() {
		List<BoardDTO> boardList = null;

		boardList = mapper.getAllBoard();

		return boardList;
	}

	public BoardDTO getBoardByBoardNo(int boardNo) {
		BoardDTO board = null;

		board = mapper.getBoardByBoardNo(boardNo);

		return board;
	}
	
	public void createBoard(BoardDTO boardDTO) {
		mapper.insertBoard(boardDTO);
	}
	
	public boolean updateBoard(BoardDTO board) {
		boolean result = false;

		int res = mapper.updateBoard(board);
		if (res != 0) {
			result = true;
		} else {
			new Exception("게시판 수정 실패");
		}

		return result;
	}

	public boolean deleteBoardByBoradNo(int boardNo) {
		boolean result = false;

		int res = mapper.deleteBoardByBoradNo(boardNo);

		if (res != 0) {
			result = true;
			return result;
		}
		return false;
	}

}
