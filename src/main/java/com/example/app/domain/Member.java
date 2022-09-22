package com.example.app.domain;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class Member {
	
	private Integer id;
	@NotBlank(message = "名前を入力してください")
	@Size(max=10,message="10字以内で入力してください")
	private String name;
	
	@Range(min=0,max=120)
	@Min(value=0,message="0以上の整数を入力してください")
	private Integer age;
	
	@Size(max=255)
	private String address;
	
	private Integer typeId;
	
	private String born;
	
	private Date created;

}
