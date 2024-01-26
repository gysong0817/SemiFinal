package com.miniproject.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.miniproject.dto.BoardDTO;
import com.miniproject.dto.FileDTO;
import com.miniproject.mapper.FileMapper;

@Service
public class FileService {
	
	@Autowired
	FileMapper fileMapper;
	
	public FileDTO getFileByBoardNo(int boardNo) { 
		FileDTO file = null;
		
		file = fileMapper.getFileByBoardNo(boardNo);
		
		return file;
	}
	
	
	public boolean createFile(MultipartFile file, int boardNo) throws Exception {
		boolean result = false;
		
		if(file == null) {
			throw new Exception("파일 전달 오류 발생");
		}
		
		String filePath = "C:\\multi\\00.spring";
		String fileOriginalName = file.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + fileOriginalName;
		Long fileSize = file.getSize();
		
		FileDTO fileDTO = FileDTO.builder()
								.fileOriginalName(fileOriginalName)
								.fileName(fileName)
								.fileSize(fileSize)
								.filePath(filePath)
								.boardNo(boardNo)
								.build();
		
		int res = fileMapper.createFile(fileDTO);
		
		if (res != 0) {
			file.transferTo(new File(filePath + "\\" + fileName));
			result = true;
		}
		
		return result;
	}
	


}
