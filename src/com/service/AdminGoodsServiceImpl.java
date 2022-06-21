package com.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminGoodsDao;
import com.po.Product;
import com.po.User;

@Service("adminGoodsService")
@Transactional
public class AdminGoodsServiceImpl implements AdminGoodsService{
	@Autowired
	private AdminGoodsDao adminGoodsDao;
	//分页查询商品
	public String selectGoods(Model model, Integer pageCur, String act) {
		int pagesize = 15;
		List<Product> allGoods = adminGoodsDao.selectGoods();
		System.out.println("查询所有订单");
		System.out.println(allGoods);
		int temp = allGoods.size();
		model.addAttribute("totalCount", temp);
		int totalPage = 0;
		if (temp == 0) {
			totalPage = 1;//总页数
		} else {
			//返回大于或者等于指定表达式的最小整数
			totalPage = (int) Math.ceil((double) temp / pagesize);
		}
		if (pageCur == null) {
			pageCur = 1;
		}
		if ((pageCur - 1) * pagesize > temp) {
			pageCur = pageCur - 1;
		}
		//分页查询
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", (pageCur - 1) * pagesize);//起始位置
		map.put("perPageSize", pagesize);//每页10个
		allGoods = adminGoodsDao.selectAllGoodsByPage(map);
		model.addAttribute("allGoods", allGoods);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCur", pageCur);
		//删除查询
		if("deleteSelect".equals(act)){
			return "backend/deleteSelectGoods";
		}
		//修改查询
		else if("updateSelect".equals(act)){
			return "backend/updateSelectGoods";
		}else{
			return "backend/index";
		}
	}
	//修改商品信息
	public String updateAProd(Product product,Model model, HttpServletRequest request) {
		System.out.println("修改商品："+product.toString()+"------------");
		List<Product> list = adminGoodsDao.selectProdByName(product.getName());
		if(list.size()>0) {
			Product product2 = list.get(0);
			if(!product2.getId().equals(product.getId())) {
				model.addAttribute("msg", "此商品名已被使用");
				Product product3 = adminGoodsDao.selectProdById(product.getId());
				model.addAttribute("product", product3);
				return "backend/proddetail";
			}
		}
		
		if(product.getLogo().getOriginalFilename()!="") {
			System.out.println("修改图片:"+product.getLogo().getOriginalFilename());
			Product oldProduct = adminGoodsDao.selectProdById(product.getId());
			String oldpath = oldProduct.getImgurl();
			System.out.println("原图片:"+oldProduct.getImgurl());
			
			
			
			String newImgName = "";
			String realpath = request.getServletContext().getRealPath("/img/");
			System.out.println("path:"+realpath);
			String imgName = product.getLogo().getOriginalFilename();

			File oldFile = new File(realpath, oldpath);
			oldFile.delete();
			
			String fileType=imgName.substring(imgName.lastIndexOf('.'));
			newImgName = product.getId()+fileType;
			
			product.setImgurl(newImgName);
			
			File targetFile = new File(realpath, newImgName);
			
			if(!targetFile.exists()) {
				targetFile.mkdirs();
			}
			
			try {
				product.getLogo().transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(adminGoodsDao.updateProdById(product)>0) {
				return "redirect:/backend/index";
			}
			else {
				model.addAttribute("msg", "修改失败");
				Product product3 = adminGoodsDao.selectProdById(product.getId());
				model.addAttribute("product", product3);
				return "backend/proddetail";
			}
		} else {
			if(adminGoodsDao.updateProdById(product)>0) {
				return "redirect:/backend/index";
			}
			else {
				model.addAttribute("msg", "修改失败");
				Product product3 = adminGoodsDao.selectProdById(product.getId());
				model.addAttribute("product", product3);
				return "backend/proddetail";
			}
		}
		
	}
	//添加商品
	public String addProduct(Product product, Model model, HttpServletRequest request) {
		System.out.println("------添加商品------");
		System.out.println(product.toString());
		List<Product> list = adminGoodsDao.selectProdByName(product.getName());
		if(list.size()>0) {
			model.addAttribute("msg","已有此商品");
			return "err";
		}
		Product product2 = adminGoodsDao.selectProdById(product.getId());
		if(product2!=null) {
			model.addAttribute("msg","此商品ID已使用");
			return "err";
		}
		String newImgName = "";
		String realpath = "";
		String imgName = product.getLogo().getOriginalFilename();
		if(imgName.length()>0) {
			realpath = request.getServletContext().getRealPath("/img/");
			System.out.println("path:"+realpath);
		}
		String fileType=imgName.substring(imgName.lastIndexOf('.'));
		newImgName = product.getId()+fileType;
		
		product.setImgurl(newImgName);
		
		File targetFile = new File(realpath, newImgName);
		
		if(!targetFile.exists()) {
			targetFile.mkdirs();
		}
		
		try {
			product.getLogo().transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(adminGoodsDao.addProd(product)>0) {
			return "suc";
		}
		else {
			model.addAttribute("msg","添加失败");
			return "err";
		}
		
	}
	public String selectAProd(Model model, String id) {
		Product product = adminGoodsDao.selectProdById(id);
		model.addAttribute("product",product);
		model.addAttribute("msg","");
		return "backend/proddetail";
	}
	public String delete(String id) {
		if(adminGoodsDao.deleteAProd(id)>0) {
			System.out.println("删除成功");
			return "redirect:/backend/index";
		}
		else {
			System.out.println("删除失败");
			return "redirect:/backend/index";
		}		
	}
	
}
