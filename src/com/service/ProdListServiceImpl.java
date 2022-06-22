package com.service;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.ProdListDao;
import com.po.Prod;
import com.po.SearchProd;
import com.po.User;

@Service("prodListService")
@Transactional
public class ProdListServiceImpl implements ProdListService {

	@Autowired
	private ProdListDao prodListDao;
	public String before(Model model) {
		model.addAttribute("prodList", prodListDao.getProdList());
		return "before/prod_list";
	}
	public String prodInfo(Model model, String id) {
		Prod prod = prodListDao.selectProdById(id);
		model.addAttribute("prodInfo", prod);
		return "before/prod_info";
	}
	public String searchProd(Model model, String name, String category, String minPrice, String maxPrice) {
		SearchProd searchProd = new SearchProd();
		searchProd.setName(name);
		searchProd.setCategory(category);
		if (minPrice=="")
			searchProd.setMinPrice(-2d);
		else
			if (!isNumber(minPrice))
				return "before/prod_list";
			else
				searchProd.setMinPrice(Double.valueOf(minPrice));
		if (maxPrice=="")
			searchProd.setMaxPrice(-2d);
		else
			if (!isNumber(maxPrice))
				return "before/prod_list";
			else
				searchProd.setMaxPrice(Double.valueOf(maxPrice));
		model.addAttribute("prodList", prodListDao.searchProd(searchProd));
		return "before/prod_list";	
	}
	

	private boolean isNumber(String str) {
		boolean isInt = Pattern.compile("^-?[1-9]\\d*$").matcher(str).find();
        boolean isDouble = Pattern.compile("^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$").matcher(str).find();
        return isInt || isDouble;
	}
	
	public List<Prod> prodInfo(String id) {
		return prodListDao.selectProdById2(id);
	}
	
	public String searchProdByName(Model model, String name) {
		model.addAttribute("prodList", prodListDao.searchProdByName(name));
		return "before/prod_list";
	}
}
