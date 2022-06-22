package com.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Product;
import com.service.ProdListService;

@Controller
@RequestMapping("/prod_list")
public class ProdListController {
	@Autowired
	private ProdListService prodListService;
	@RequestMapping("")
	public String showProdList(Model model,HttpServletRequest req) {
		return prodListService.before(model);
	}
	
	@RequestMapping("/prod_info")
	public String showProInfo(Model model, String id) {
		System.out.println("进入商品详情");
		return prodListService.prodInfo(model, id);
	}
	@RequestMapping("/searchProd")
	public String searchProd(Model model, String name, String category, String minPrice, String maxPrice) {
		System.out.println("查询商品");
		return prodListService.searchProd(model, name, category, minPrice, maxPrice);
	}
	@RequestMapping("/searchProdByName")
	public String searchProdByName(Model model, String name) {
		System.out.println(name);
		return prodListService.searchProdByName(model, name);
	}
}
