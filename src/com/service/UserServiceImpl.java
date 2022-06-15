package com.service;

import com.dao.UserDao;
import com.po.User;
import com.po.UserRegist;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private JedisPool jedisPool;
	

	public String login(User user, HttpSession session ,Model model) {

		Jedis resource = jedisPool.getResource();
		String jsonUser = resource.get(user.getUsername());
		if(jsonUser!=null)
		{
			resource.close();
			return "/before/index";
		}
		else{
			User u = null;

			List<User> list = userDao.getUserByUsername(user);
			if(list.size()>0) {
				u = list.get(0);
			}
			if(u!=null) {
				session.setAttribute("user", u);
				JSONObject jsonObject = JSONObject.fromObject(user);
				String s = jsonObject.toString();
				resource.set(u.getUsername(),s);
				resource.close();
				System.out.println("在sql中查询成功，登陆成功！");
				return "/before/index";
			}
			else {
				model.addAttribute("msg", "用户名或密码错误！");
				return "before/login";
			}

		}

		
	}

	public String register(UserRegist user, HttpSession session ,Model model, String code) {
		System.out.println("注册验证码为："+code);
		if(!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("msg","验证码填写错误");
			return "before/regist";
		}
		
		if(user.getUsername()=="") {
			model.addAttribute("msg","信息填写错误");
			return "before/regist";
		}
		if(user.getPassword()=="") {
			model.addAttribute("msg","信息填写错误");
			return "before/regist";
		}
		if(user.getNickname()=="") {
			model.addAttribute("msg","信息填写错误");
			return "before/regist";
		}
		if(user.getEmail()=="") {
			model.addAttribute("msg","信息填写错误");
			return "before/regist";
		}
		if(!user.getPassword2().equals(user.getPassword())) {
			model.addAttribute("msg","信息填写错误");
			return "before/regist";
		}
		else {
			User u = userDao.usernameIsUse(user.getUsername());
			
			if(u!=null) {
		//	if(false) {
				model.addAttribute("msg","此用户名已经被注册");
				System.out.println("用户名已被注册");
				return "before/regist";
			}
			else {
				int a = userDao.addUser(user);
				if(a>0) {
					System.out.println("新用户id:"+a);
					return "/before/index";
				}
			}
		}
		return "before/regist";
	}

	public void test(int id) {
	id = 1;
	User user = userDao.getUserById(id);
	if(user.getUsername()=="admin")
		System.out.println("test suc");
	else {
		System.out.println("test fai");
	}
}

}