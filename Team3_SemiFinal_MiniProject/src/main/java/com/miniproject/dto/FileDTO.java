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
public class FileDTO {
	private int fileNo;
	private String filePath;
	private String fileName;
	private String fileOriginalName;
	private Long fileSize;
	private int boardNo;
	
	@Builder
	public FileDTO(int fileNo, String filePath, String fileName, String fileOriginalName, Long fileSize, int boardNo) {
		super();
		this.fileNo = fileNo;
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileOriginalName = fileOriginalName;
		this.fileSize = fileSize;
		this.boardNo = boardNo;
	}


}
