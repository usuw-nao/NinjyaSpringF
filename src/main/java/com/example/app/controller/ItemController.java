package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	ItemService service;
	
	@GetMapping
	public String list(Model model)throws Exception{
		model.addAttribute("items",service.getItemList());
		return "items/list";
	}

}
