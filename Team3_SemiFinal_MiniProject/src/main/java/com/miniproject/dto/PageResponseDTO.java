package com.miniproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class PageResponseDTO {
	
    private int pageAmount;
    
    private int startPage, endPage;
    
    private boolean prev, next;
    
    private int realEnd;

    private int total;
    
    private PageRequestDTO pageRequest;

    public PageResponseDTO(){}
    
    @Builder
    public PageResponseDTO(int total, int pageAmount, PageRequestDTO pageRequest) {
        this.total = total;
        this.pageAmount = pageAmount;
        this.pageRequest = pageRequest;

        this.endPage = (int)(Math.ceil(pageRequest.getPageNum() * 1.0 / pageAmount)) * pageAmount;
        this.startPage = endPage - (pageAmount - 1);

        realEnd = (int)(Math.ceil(total * 1.0 / pageRequest.getAmount()));

        if(endPage > realEnd){
        	this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}

