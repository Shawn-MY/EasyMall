package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BackendFilter implements Filter {
	 
	public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest)arg0;
        HttpServletResponse response = (HttpServletResponse)arg1;
        HttpSession session = request.getSession();
        // 没有userName为空就转发到登陆页面
        if(session.getAttribute("admin")==null){

            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);

//            response.sendRedirect(request.getContextPath()+"/index.jsp");  //重定向就相当于地址栏输入 也不能随便访问jsp
        }else{
            // 不为空，就继续请求下一级资源（继续访问）
            arg2.doFilter(arg0, arg1);
        }

    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

	
}

