package com.datastreams.project.vo;

import org.springframework.stereotype.Component;

@Component
public class PagingVO {
	
	private int board_count;			// 총 게시물수
	private int page_count;			//총 페이지수 
	private int page_limit;				//게시물수 제한(한페이지당 보여질 글의 갯수)	
	private int current_page;			//현재 페이지		
	private int start_page;			//시작 페이지
	private int end_page;				//마지막 페이지
	
	public int getBoard_count() {
		return board_count;
	}
	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}
	public int getPage_count() {
		return page_count;
	}
	public void setPage_count(int page_count) {
		this.page_count = page_count;
	}
	public int getPage_limit() {
		return page_limit;
	}
	public void setPage_limit(int page_limit) {
		this.page_limit = page_limit;
	}
	public int getCurrent_page() {
		return current_page;
	}
	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}
	public int getStart_page() {
			start_page =	(current_page - 1) / 5 * 5 + 1;
		return start_page;
	}
	public void setStart_page(int start_page) {
		this.start_page = start_page;
	}
	public int getEnd_page() {
			end_page = start_page + 5 - 1;
		return end_page;
	}
	public void setEnd_page(int end_page) {
		this.end_page = end_page;
	}
}
