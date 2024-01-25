package com.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.miniproject.dto.BoardDTO;
import com.miniproject.dto.PageRequestDTO;
import com.miniproject.dto.PageResponseDTO;
import com.miniproject.service.MainService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	@Autowired
	private MainService service;
	
	@GetMapping("/search")
	public String moveSearch() {
		return "search";
	}
	
	@GetMapping("/search/keyword")
	public String searchKeyword(String searchKeyword,
								Model model) {
		List<BoardDTO> boardList = service.getBoardBySearchKeyword(searchKeyword);
		model.addAttribute("boardList", boardList);
		
		return "search";
	}
	
	@GetMapping(value = "/main")
	public String searchWithPage(PageRequestDTO pageRequest,
								Model model) {
		
		List<BoardDTO> boardList = service.getBoardBySeachWithPage(pageRequest);
		
		int totalCount = service.getTotalCount(pageRequest);
		
		PageResponseDTO pageResponse = new PageResponseDTO().builder()
										.total(totalCount)
										.pageAmount(pageRequest.getAmount())
										.pageRequest(pageRequest)
										.build();
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageInfo", pageResponse);
		System.out.println(boardList);
		
		return "main";
	}
}