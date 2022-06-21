package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("/")
	public String showIndex() {
		System.out.println("������ҳ");
		return "before/index";
	}
	@RequestMapping("/login")
	public String showLogin() {
		System.out.println("�����¼ҳ��");
		return "before/login";
	}
	@RequestMapping("/register")
	public String showRegist() {
		System.out.println("����ע��ҳ��");
		return "before/regist";
	}
	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		System.out.println("�˳���¼");
		return "forward:/";
	}
	@RequestMapping("/cart")
	public String showCart() {
		System.out.println("���빺�ﳵҳ��");
		return "before/cart";
	}
}
