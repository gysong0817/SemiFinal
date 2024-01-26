package com.miniproject.controller;

import java.util.HashMap;
import java.util.Map;

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
	
	@RequestMapping(value = "/board/{boardno}", method = RequestMethod.POST)
	public String updateBoard(@PathVariable int boardno, @ModelAttribute("newBoard") BoardDTO newBoard) {
	    String view = "error";

	    BoardDTO board = null;
	    boolean result = false;

	    board = service.getBoardByBoardNo(boardno);

	    board.setTitle(newBoard.getTitle());
	    board.setContent(newBoard.getContent());

	    result = service.updateBoard(board);

	    if (result) {
	        view = "redirect:/board/" + boardno;
	    }

	    return view;
	}
	
	@RequestMapping(value = "/board/{boardNo}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, String>> deleteBoard(@PathVariable(name = "boardNo") int boardNo) {
	    Map<String, String> response = new HashMap<>();
	    try {
	        service.deleteBoardByBoradNo(boardNo);
	        response.put("message", "게시물이 삭제되었습니다.");
	        return ResponseEntity.ok(response);
	    } catch (BoardDeleteException e) {
	        response.put("message", e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    } catch (Exception e) {
	        logger.error("Error deleting board with boardNo: " + boardNo, e);
	        response.put("message", "게시물 삭제 중 오류가 발생했습니다.");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}


	
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(@RequestParam("boardNo") int boardNo, Model model) {
	    BoardDTO board = service.getBoardByBoardNo(boardNo);

	    model.addAttribute("board", board);

	    return "boardDetail";
	}
	
	public class BoardDeleteException extends RuntimeException {

	    public BoardDeleteException(String message) {
	        super(message);
	    }
	}

	
}
