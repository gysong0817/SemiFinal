package com.miniproject.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardDTO {
	private int boardNo;
	private String title;
	private String content;
	private String userId;
	private Date regDate;
	private Date modDate;
	private int viewCnt;
	
	@Builder
	public BoardDTO(int boardNo, String title, String content, String userId, Date regDate, Date modDate, int viewCnt) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.regDate = regDate;
		this.modDate = modDate;
		this.viewCnt = viewCnt;
	}
	
	
	
}
