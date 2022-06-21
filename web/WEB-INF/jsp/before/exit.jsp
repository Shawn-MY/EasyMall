<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
session.invalidate();
response.sendRedirect(request.getContextPath()+"/index.jsp");
%>
