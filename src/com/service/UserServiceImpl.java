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
				System.out.println("��sql�в�ѯ�ɹ�����½�ɹ���");
				return "/before/index";
			}
			else {
				model.addAttribute("msg", "�û������������");
				return "before/login";
			}

		}

		
	}

	public String register(UserRegist user, HttpSession session ,Model model, String code) {
		System.out.println("ע����֤��Ϊ��"+code);
		if(!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("msg","��֤����д����");
			return "before/regist";
		}
		
		if(user.getUsername()=="") {
			model.addAttribute("msg","��Ϣ��д����");
			return "before/regist";
		}
		if(user.getPassword()=="") {
			model.addAttribute("msg","��Ϣ��д����");
			return "before/regist";
		}
		if(user.getNickname()=="") {
			model.addAttribute("msg","��Ϣ��д����");
			return "before/regist";
		}
		if(user.getEmail()=="") {
			model.addAttribute("msg","��Ϣ��д����");
			return "before/regist";
		}
		if(!user.getPassword2().equals(user.getPassword())) {
			model.addAttribute("msg","��Ϣ��д����");
			return "before/regist";
		}
		else {
			User u = userDao.usernameIsUse(user.getUsername());
			
			if(u!=null) {
		//	if(false) {
				model.addAttribute("msg","���û����Ѿ���ע��");
				System.out.println("�û����ѱ�ע��");
				return "before/regist";
			}
			else {
				int a = userDao.addUser(user);
				if(a>0) {
					System.out.println("���û�id:"+a);
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