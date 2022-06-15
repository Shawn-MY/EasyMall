package com.controller;

import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.UserService;

import com.po.User;
import com.po.UserRegist;
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Log logger = LogFactory.getLog(UserController.class);
	@Autowired
	 public UserService userService;
	@RequestMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session, Model model) {
		return userService.login(user, session, model);
	}
	@RequestMapping("/register")
	public String register(@ModelAttribute UserRegist user, HttpSession session, Model model, String code) {
		return userService.register(user, session, model, code);
	}
}
