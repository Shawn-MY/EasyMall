package com.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.po.Product;

public interface AdminGoodsService {
	public String selectGoods(Model model, Integer pageCur, String act);
	public String addProduct(@ModelAttribute  Product product, Model model, HttpServletRequest request);
	public String selectAProd(Model model, String id);
	public String updateAProd(@ModelAttribute Product product,Model model, HttpServletRequest request);
	public String delete(String id);
}
