package com.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CartDao;
import com.po.Product;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Service("cartService")
@Transactional
//���ﳵ
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;
	
	public void getPro(HttpServletRequest req, HttpServletResponse res) {
		String pid = req.getParameter("pid");
		System.out.println(pid);
		int buyNum = Integer.parseInt(req.getParameter("buyNum"));
		Map<Product, Integer> map = null;
		Product product = cartDao.getPro(pid);
		System.out.println(product.toString());
		if(product!=null) {
			
			map = (Map<Product, Integer>)req.getSession().getAttribute("cartmap");
			if(map==null) {
				req.getSession().setAttribute("cartmap", new HashMap<Product, Integer>());
				map = (Map<Product, Integer>)req.getSession().getAttribute("cartmap");
			}
			System.out.print("����ǰmap:");
			System.out.println(map);
			
			if(buyNum < 0) {
				map.remove(product);
			} else {
				map.put(product, map.containsKey(product) ? map.get(product) + buyNum : buyNum);
				System.out.print("�����map:");
				System.out.println(map);
			}
		}
	}

	public void update(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String pid = req.getParameter("pid");
		int buyNum = Integer.parseInt(req.getParameter("buyNum"));
		Map<Product, Integer> map = null;
		Product product = cartDao.getPro(pid);
		if(product!=null) {
			map = (Map<Product, Integer>)req.getSession().getAttribute("cartmap");
		}
		
		map.put(product, buyNum);
		System.out.println("��Ʒ"+pid+"����������Ϊ:"+buyNum);
	}

}
