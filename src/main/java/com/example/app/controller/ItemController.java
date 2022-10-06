package com.example.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Item;
import com.example.app.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemService service;

	@GetMapping
	public String list(Model model) throws Exception {
		model.addAttribute("items", service.getItemList());
		return "items/list";
	}

	@GetMapping("/add")
	public String addGet(Model model) throws Exception {
			model.addAttribute("title", "忍具の追加");
			model.addAttribute("item",new Item());
			model.addAttribute("types",service.getTypeList());			
			return "items/save";
		}
	@PostMapping("/add")
	public String addPost(
			@Valid Item item,
			Errors errors,
			RedirectAttributes rd,
			Model model)throws Exception{
		if(errors.hasErrors()) {
			model.addAttribute("title","忍具の追加");
			model.addAttribute("types",service.getTypeList());
			return "items/save";
		}
		service.addItem(item);
		rd.addFlashAttribute("statusMessage","忍具を追加しました");
		return "redirect:/items";
	}
	
	

	@GetMapping("/edit/{id}")
	public String editGet(@PathVariable Integer id, Model model) throws Exception {
		model.addAttribute("title", "忍具の変更");
		model.addAttribute("item", service.getItemId(id));
		model.addAttribute("types", service.getTypeList());
		return "items/save";
	}

	@PostMapping("/edit/{id}")
	public String editPost(@PathVariable Integer id, @Valid Item item, Errors errors, RedirectAttributes rd,
			Model model) throws Exception {
		if (errors.hasErrors()) {
			model.addAttribute("title", "忍具の変更");
			model.addAttribute("types", service.getTypeList());
			return "items/save";
		}

		item.setId(id);
		service.editItem(item);
		rd.addFlashAttribute("statusMessage", "会員情報を更新しました");
		return "redirect:/items";

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes rd) throws Exception {
		service.deleteItem(id);
		rd.addFlashAttribute("statusMessage", "！注意！忍具情報を削除しました！注意！");
		return "redirect:/items";
	}

}
