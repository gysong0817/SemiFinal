package com.miniproject.controller;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.miniproject.dto.CommentDTO;
import com.miniproject.dto.UserDTO;
import com.miniproject.service.CommentService;
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	@ResponseBody
	@RequestMapping("/list")
	public String CommentList(@RequestParam("boardNo")int boardNo, Model model){
	    ArrayList<CommentDTO> comments = service.CommentList(boardNo);
	    model.addAttribute("comments", comments);
	    return "Boardview"; // 댓글 목록을 포함한 화면으로 이동
	}
	
	
	@GetMapping("insert")
	public String insertComment(@RequestParam("boardNo")int boardNo , Model model) {
		model.addAttribute("boardNo", boardNo);
		return "Boardview";
		
	}
	
	@ResponseBody
	@PostMapping("insert")
	public String PostInsertComment(CommentDTO dto, HttpSession session, Model model) {
	    Object tmp = session.getAttribute("userId");
	    if (tmp != null && tmp instanceof UserDTO) {
	        UserDTO userDTO = (UserDTO) tmp;
	        dto.setUserId(userDTO.getUserId());
	    } else {
	        // 세션에서 "userId"가 UserDTO 형태로 저장되어 있지 않을 경우에 대한 처리
	        // 예를 들어 로그인이 되어 있지 않은 상태 등
	    }
	    return service.insertComment(dto);
	}
	
	@GetMapping("update")
	public String updateComment(CommentDTO dto) {
		System.out.println(dto.getCommentNo());
		System.out.println(dto.getContent());
		 service.updateComment(dto);	
		return "Member/Comment/insert";
	}
	
	@ResponseBody
	@PostMapping("update")
	public String PostUpdateComment(CommentDTO dto) {
		return service.updateComment(dto);
	}
	
	@ResponseBody
	@PostMapping("delete")
	public String deleteComment(@RequestParam("CommentNo")int CommentNo) {
		
		return service.deleteComment(CommentNo);
	}
	
}