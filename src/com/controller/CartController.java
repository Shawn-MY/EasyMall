package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/cartadd")
	public String showCart(HttpServletRequest req, HttpServletResponse res) {
		cartService.getPro(req, res);
		return "redirect:/cart";
	}
	@RequestMapping("/update")
	public String updateCart(HttpServletRequest req, HttpServletResponse res) {
		cartService.update(req, res);
		return "redirect:/cart";
	}
}
