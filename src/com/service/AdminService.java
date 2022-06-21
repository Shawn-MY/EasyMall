package com.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.po.Admin;

public interface AdminService {
	public String login(Admin admin, HttpSession session, Model model);
}
