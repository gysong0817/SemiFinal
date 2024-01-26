package com.miniproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.miniproject.dto.FileDTO;

@Mapper
public interface FileMapper {

	public int createFile(FileDTO fileDTO);

	FileDTO getFileByBoardNo(int boardNo);

}