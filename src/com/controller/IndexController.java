package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("/")
	public String showIndex() {
		System.out.println("进入首页");
		return "before/index";
	}
	@RequestMapping("/login")
	public String showLogin() {
		System.out.println("进入登录页面");
		return "before/login";
	}
	@RequestMapping("/register")
	public String showRegist() {
		System.out.println("进入注册页面");
		return "before/regist";
	}
	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		System.out.println("退出登录");
		return "forward:/";
	}
	@RequestMapping("/cart")
	public String showCart() {
		System.out.println("进入购物车页面");
		return "before/cart";
	}
}
