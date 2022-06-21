package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AdminIndexController {
	@RequestMapping("/backend/")
	public String showLogin() {
		System.out.println("进入后台登录页");
		return "backend/login";
	}

}
