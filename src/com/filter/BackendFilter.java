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
        // û��userNameΪ�վ�ת������½ҳ��
        if(session.getAttribute("admin")==null){

            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);

//            response.sendRedirect(request.getContextPath()+"/index.jsp");  //�ض�����൱�ڵ�ַ������ Ҳ����������jsp
        }else{
            // ��Ϊ�գ��ͼ���������һ����Դ���������ʣ�
            arg2.doFilter(arg0, arg1);
        }

    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

	
}

