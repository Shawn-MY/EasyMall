package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Product;

@Repository("cartDao")
@Mapper
public interface CartDao {
	public Product getPro(String pid);
}
