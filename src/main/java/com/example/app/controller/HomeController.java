package com.example.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.Admin;
import com.example.app.service.AdminService;

@Controller
public class HomeController {

	@Autowired
	AdminService service;

	@GetMapping
	public String showHome(Model model) {
		model.addAttribute("admin", new Admin());
		return "home";
	}

	@PostMapping
	public String login(@Valid Admin admin, Errors errors, HttpSession session) throws Exception {
		// 入力不備
		if (errors.hasErrors()) {
			return "home";
		}
		// パスワードが違う
		if (!service.isCorrectIdAndPassword(admin.getLoginId(), admin.getLoginPass())) {
			errors.rejectValue("loginId", "error.incorrect_id_password");
			return "home";
		}
		// 正しい時
		session.setAttribute("loginId", admin.getLoginId());
		return "redirect:/";
	}

}
