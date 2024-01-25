package com.miniproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miniproject.dto.BoardDTO;
import com.miniproject.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "/board/{boardNo}", method = RequestMethod.GET)
	public String getBoardByBoardNo(@PathVariable int boardNo, Model model) {
		BoardDTO board = null;
		
		board = service.getBoardByBoardNo(boardNo);
		model.addAttribute("board", board);
		
		return "boardDetail";
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createBoard(@RequestBody BoardDTO boardDTO) {
	    service.createBoard(boardDTO);
	    return new ResponseEntity<>("Board created successfully", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/modify/board/{boardno}", method = RequestMethod.GET)
	public String updateBoardForm(@PathVariable int boardno, Model model) {
		
		BoardDTO board = service.getBoardByBoardNo(boardno);
		
		model.addAttribute("board", board);
		
		return "updateBoard";
	}
	
	@RequestMapping(value = "/board/{boardno}", method = RequestMethod.PUT)
	public String updateBoard(@PathVariable int boardno,
							@ModelAttribute BoardDTO newBoard) {
		
		String view = "error";
		
		BoardDTO board = null;
		boolean result = false;
		
		board = service.getBoardByBoardNo(boardno);
		
		board.setTitle(newBoard.getTitle());
		board.setContent(newBoard.getContent());
		
		result = service.updateBoard(board);
		
		
		if (result) {
			view = "redirect:/board/" + boardno;
			return view;
		}
		return view;
	}
	
	@RequestMapping(value= "/board/{boardno}", method = RequestMethod.DELETE)
	public String DeleteBoard(@PathVariable int boardNo) {
		
		String view ="error";
		boolean result = false;
		
		result = service.deleteBoardByBoradNo(boardNo);
		
		if(result) {
			view ="redirect:/main";
			return view;
		}
		return view;
	}
	
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(@RequestParam("boardNo") int boardNo, Model model) {
	    BoardDTO board = service.getBoardByBoardNo(boardNo);

	    model.addAttribute("board", board);

	    return "boardDetail";
	}

}
