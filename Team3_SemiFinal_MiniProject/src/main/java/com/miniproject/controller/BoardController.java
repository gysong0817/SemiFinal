package com.miniproject.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.miniproject.dto.BoardDTO;
import com.miniproject.dto.FileDTO;
import com.miniproject.service.BoardService;
import com.miniproject.service.FileService;



@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping(value = "/board/{boardNo}", method = RequestMethod.GET)
	public String getBoardByBoardNo(@PathVariable int boardNo, Model model) {
		BoardDTO board = null;
		FileDTO file = null;
		
		board = service.getBoardByBoardNo(boardNo);
		file = fileService.getFileByBoardNo(boardNo);
		
		model.addAttribute("board", board);
		model.addAttribute("file", file);
		
		System.out.println(board);
		System.out.println(file);
		
		return "boardDetail";
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String createBoardForm(HttpServletRequest request) {
		return "createBoard";
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.POST)
	public String createBoard(@ModelAttribute BoardDTO newBoard,
								HttpServletRequest request,
								MultipartFile file) {
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("userId");
			
		String view = "erorr";
		boolean result = false;
		boolean fileResult =false;
		
		
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		System.out.println(newBoard);
		try {
		
			result = service.createBoard(newBoard);
			
			if (file != null) {
				fileResult = fileService.createFile(file, newBoard.getBoardNo());
			}
		
			if (result || fileResult) {
				view = "redirect:/main";
				return view;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		
		return view;
	}
	
//	@RequestMapping(value = "/modify/board/{boardno}", method = RequestMethod.GET)
//	public String updateBoardForm(@PathVariable int boardno, Model model) {
//		
//		BoardDTO board = service.getBoardByBoardNo(boardno);
//		
//		model.addAttribute("board", board);
//		
//		return "updateBoard";
//	}
//	
//	@RequestMapping(value = "/board/{boardno}", method = RequestMethod.PUT)
//	public String updateBoard(@PathVariable int boardno,
//							@ModelAttribute BoardDTO newBoard) {
//		
//		String view = "error";
//		
//		BoardDTO board = null;
//		boolean result = false;
//		
//		board = service.getBoardByBoardNo(boardno);
//		
//		board.setTitle(newBoard.getTitle());
//		board.setContent(newBoard.getContent());
//		
//		result = service.updateBoard(board);
//		
//		
//		if (result) {
//			view = "redirect:/board/" + boardno;
//			return view;
//		}
//		return view;
//	}
//	
//	@RequestMapping(value= "/board/{boardno}", method = RequestMethod.DELETE)
//	public String DeleteBoard(@PathVariable int boardNo) {
//		
//		String view ="error";
//		boolean result = false;
//		
//		result = service.deleteBoardByBoradNo(boardNo);
//		
//		if(result) {
//			view ="redirect:/main";
//			return view;
//		}
//		return view;
//	}
//	
//	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
//	public String boardDetail(@RequestParam("boardNo") int boardNo, Model model) {
//	    BoardDTO board = service.getBoardByBoardNo(boardNo);
//
//	    model.addAttribute("board", board);
//
//	    return "boardDetail";
//	}
}
