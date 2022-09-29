package com.example.app.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class NewsForm {
	
	//News
	@NotBlank
	private String title;
	private String author;
	private Date postDate = new Date();
	
	//NewsBlank
	@NotBlank
	private String article;
	
	private List<Integer>targetIdList;

}
