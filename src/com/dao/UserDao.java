package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.User;
import com.po.UserRegist;

@Repository("userDao")
@Mapper
public interface UserDao {	
	public List<User> getUserByUsername(User user);
	public User getUserById(int id);
	public int addUser(UserRegist user);
	public User usernameIsUse(String username);
	
}
