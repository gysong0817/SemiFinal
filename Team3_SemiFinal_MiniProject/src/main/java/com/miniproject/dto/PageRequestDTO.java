package com.miniproject.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class PageRequestDTO {

	  private int pageNum;
	
	  private int amount;

	  private String searchKeyword;
	  
	  public PageRequestDTO() {
	    this(1, 5);
	  }
	  
	  public PageRequestDTO(int pageNum, int amount) {
		  super();
		  this.pageNum = pageNum;
		  this.amount = amount;
	  } 
	  
	  @Builder
	  public PageRequestDTO(int pageNum, int amount, String searchKeyword) {
		    super();
		    this.pageNum = pageNum;
		    this.amount = amount;
		    this.searchKeyword = searchKeyword;
	  }
}

