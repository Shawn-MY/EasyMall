package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.po.User;
import com.po.UserRegist;

public interface UserService {
//	public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model);
	public String register(UserRegist user, HttpSession session, Model model, String code);
	public String login(User user, HttpSession session, Model model);
	public void test(int id);
}
