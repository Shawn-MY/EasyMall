package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import com.po.Product;

@Repository("adminGoodsDao")
@Mapper
public interface AdminGoodsDao {
	public List<Product> selectAllGoodsByPage(Map<String, Object> map);
	public List<Product> selectGoods();
	public int addProd(Product product);
	public List<Product> selectProdByName(String name);
	public Product selectProdById(String id);
	public int updateProdById(Product product);
	public int deleteAProd(String id);
}
