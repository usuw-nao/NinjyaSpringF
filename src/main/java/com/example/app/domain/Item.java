package com.example.app.domain;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Item {
	
	
	private Integer id;
	
	@NotBlank
	private String itemId;
	
	@NotBlank
	private String name;
	
	
	private Integer number;
	private Integer no;
	private Integer yes;
	private Integer destroy;
	private String text;
	

}
