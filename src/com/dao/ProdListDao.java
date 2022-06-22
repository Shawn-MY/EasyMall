package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Prod;
import com.po.Product;
import com.po.SearchProd;

@Repository("prodListDao")
@Mapper
public interface ProdListDao {
	public List<Map<String, Object>> getProdList();
	public Prod selectProdById(String id);
	public List<Prod> selectProdById2(String id);
	public List<Map<String, Object>> searchProd(SearchProd searchProd);
	public List<Map<String, Object>> searchProdByName(String name);
}
