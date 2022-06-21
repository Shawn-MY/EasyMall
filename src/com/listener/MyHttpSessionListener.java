package com.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.po.Product;

@Service
public class MyHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent sess) {
		// TODO Auto-generated method stub
		System.out.println("Session创建开始-----");
		sess.getSession().setAttribute("cartmap", new HashMap<Product, Integer>());
		System.out.println("Session创建完成-----");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("Session销毁开始-----");
		
	}
	
	private Object getObjectFromApplication(ServletContext servletContext, String beanName) {
		ApplicationContext application = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		System.out.println("listener Bean");
		return application.getBean(beanName);
	}
}
