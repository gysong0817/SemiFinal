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
public class CommentDTO {
	private int commentNo;
	private int boardNo;
	private String content;
	private String userId;
	private Date regDate;
	private Date modDate;
	
	@Builder
	public CommentDTO(int commentNo, int boardNo, String content, String userId, Date regDate, Date modDate) {
		super();
		this.commentNo = commentNo;
		this.boardNo = boardNo;
		this.content = content;
		this.userId = userId;
		this.regDate = regDate;
		this.modDate = modDate;
	}
}