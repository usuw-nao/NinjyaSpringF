package com.example.app.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RepairFormItem {
	//名前
	private String name;
	//連絡先
	private String hikyaku;
	//
	private Integer number;
	//修理したいものの名前
	private Repair repair;
	//預けた日
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	//かかる時間帯
	private List<Integer>time;
	//受け取る日
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private Boolean agreement;
	

}
