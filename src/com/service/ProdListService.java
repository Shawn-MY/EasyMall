package com.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.po.Prod;
import com.po.Product;

public interface ProdListService {
	public String before(Model model);
	public String prodInfo(Model model,String id);
	public String searchProd(Model model, String name, String category, String minPrice, String maxPrice);
	public String searchProdByName(Model model, String name);
	public List<Prod> prodInfo(String id);
	
}

