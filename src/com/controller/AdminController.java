package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Admin;
import com.service.AdminService;

@Controller
@RequestMapping("/backend")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/login")
	public String login(@ModelAttribute Admin admin, HttpSession session, Model model) {
		return adminService.login(admin, session, model);
	}
	@RequestMapping("/exit")
	public String exit() {
		return "forward:/backend/";
	}
	@RequestMapping("/addprod")
	public String addprod() {
		return "backend/addprod";
	}
}
