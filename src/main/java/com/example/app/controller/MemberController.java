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

import com.example.app.domain.Member;
import com.example.app.mapper.MemberMapper;
import com.example.app.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping
	public String list(Model model)throws Exception{
		model.addAttribute("members",service.getMemberList());
		return "members/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,RedirectAttributes rd)
	throws Exception{
		service.deleteMember(id);
		rd.addFlashAttribute("statusMessage","会員情報を削除しました");
		return "redirect:/members";
	}
	@GetMapping("add")
	public String add(Model model)throws Exception{
		Member member = new Member();
		member.setAge(20);
		member.setTypeId(1);
		model.addAttribute("member",member);
		return "addMember";
	}
	
	@PostMapping("add")
	public String add(@Valid Member member,Errors errors)throws Exception{
		if(errors.hasErrors()) {
			return "addMember";
		}
		service.addMember(member);
		return "redirect:/";
	}

}
