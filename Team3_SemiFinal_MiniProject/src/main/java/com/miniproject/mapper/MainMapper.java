package com.miniproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.miniproject.dto.BoardDTO;
import com.miniproject.dto.PageRequestDTO;



@Mapper
public interface MainMapper {

	public List<BoardDTO> getBoardBySearchKeyword(String searchKeyword);

	public int getTotalCount(PageRequestDTO pageRequest);

	public List<BoardDTO> getBoardBySeachWithPage(PageRequestDTO pageRequest);
	
}
