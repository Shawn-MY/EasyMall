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
	//��ҳ��ѯ��Ʒ
	public String selectGoods(Model model, Integer pageCur, String act) {
		int pagesize = 15;
		List<Product> allGoods = adminGoodsDao.selectGoods();
		System.out.println("��ѯ���ж���");
		System.out.println(allGoods);
		int temp = allGoods.size();
		model.addAttribute("totalCount", temp);
		int totalPage = 0;
		if (temp == 0) {
			totalPage = 1;//��ҳ��
		} else {
			//���ش��ڻ��ߵ���ָ�����ʽ����С����
			totalPage = (int) Math.ceil((double) temp / pagesize);
		}
		if (pageCur == null) {
			pageCur = 1;
		}
		if ((pageCur - 1) * pagesize > temp) {
			pageCur = pageCur - 1;
		}
		//��ҳ��ѯ
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", (pageCur - 1) * pagesize);//��ʼλ��
		map.put("perPageSize", pagesize);//ÿҳ10��
		allGoods = adminGoodsDao.selectAllGoodsByPage(map);
		model.addAttribute("allGoods", allGoods);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCur", pageCur);
		//ɾ����ѯ
		if("deleteSelect".equals(act)){
			return "backend/deleteSelectGoods";
		}
		//�޸Ĳ�ѯ
		else if("updateSelect".equals(act)){
			return "backend/updateSelectGoods";
		}else{
			return "backend/index";
		}
	}
	//�޸���Ʒ��Ϣ
	public String updateAProd(Product product,Model model, HttpServletRequest request) {
		System.out.println("�޸���Ʒ��"+product.toString()+"------------");
		List<Product> list = adminGoodsDao.selectProdByName(product.getName());
		if(list.size()>0) {
			Product product2 = list.get(0);
			if(!product2.getId().equals(product.getId())) {
				model.addAttribute("msg", "����Ʒ���ѱ�ʹ��");
				Product product3 = adminGoodsDao.selectProdById(product.getId());
				model.addAttribute("product", product3);
				return "backend/proddetail";
			}
		}
		
		if(product.getLogo().getOriginalFilename()!="") {
			System.out.println("�޸�ͼƬ:"+product.getLogo().getOriginalFilename());
			Product oldProduct = adminGoodsDao.selectProdById(product.getId());
			String oldpath = oldProduct.getImgurl();
			System.out.println("ԭͼƬ:"+oldProduct.getImgurl());
			
			
			
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
				model.addAttribute("msg", "�޸�ʧ��");
				Product product3 = adminGoodsDao.selectProdById(product.getId());
				model.addAttribute("product", product3);
				return "backend/proddetail";
			}
		} else {
			if(adminGoodsDao.updateProdById(product)>0) {
				return "redirect:/backend/index";
			}
			else {
				model.addAttribute("msg", "�޸�ʧ��");
				Product product3 = adminGoodsDao.selectProdById(product.getId());
				model.addAttribute("product", product3);
				return "backend/proddetail";
			}
		}
		
	}
	//�����Ʒ
	public String addProduct(Product product, Model model, HttpServletRequest request) {
		System.out.println("------�����Ʒ------");
		System.out.println(product.toString());
		List<Product> list = adminGoodsDao.selectProdByName(product.getName());
		if(list.size()>0) {
			model.addAttribute("msg","���д���Ʒ");
			return "err";
		}
		Product product2 = adminGoodsDao.selectProdById(product.getId());
		if(product2!=null) {
			model.addAttribute("msg","����ƷID��ʹ��");
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
			model.addAttribute("msg","���ʧ��");
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
			System.out.println("ɾ���ɹ�");
			return "redirect:/backend/index";
		}
		else {
			System.out.println("ɾ��ʧ��");
			return "redirect:/backend/index";
		}		
	}
	
}
