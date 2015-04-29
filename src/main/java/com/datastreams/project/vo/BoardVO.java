package com.datastreams.project.vo;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class BoardVO {
	
	
	private String name;
	/*
	 * JSR 303이 제공하는 어노테이션을 이용해서 값 검증 규칙을 설정할수 있다. 
	 */
	@NotEmpty
	private String title;
	@NotEmpty
	private String content;
	private int hit;
	private int test;
	Timestamp bDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getTest() {
		return test;
	}
	public void setTest(int test) {
		this.test = test;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	

}
