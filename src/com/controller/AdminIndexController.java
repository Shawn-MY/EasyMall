package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AdminIndexController {
	@RequestMapping("/backend/")
	public String showLogin() {
		System.out.println("�����̨��¼ҳ");
		return "backend/login";
	}

}
