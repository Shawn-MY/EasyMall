package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminDao;
import com.po.Admin;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;

	public String login(Admin admin, HttpSession session, Model model) {
		System.out.println("后台登录请求");
		Admin a = null;
		List<Admin> list = adminDao.login(admin);
		if(list.size()>0) {
			a = list.get(0);
		}
		if(a!=null) {
			session.setAttribute("admin", a);
			System.out.println("后台登录成功");
			session.setAttribute("isLogin", "yes");
			return "redirect:/backend/index";
		}
		else {
			model.addAttribute("msg", "用户名或密码错误！");
			System.out.println("后台登录失败");
			return "backend/login";
		}
	}
	
	
	
	
}
