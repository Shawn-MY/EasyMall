<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
		<title>肖肖商城欢迎您登陆</title>
	</head>
	<body>
		<h1>欢迎登陆肖肖商城</h1>
		<form action="${pageContext.request.contextPath}/user/login" method="POST"  >
			<table>
				<tr>
					
				<%
		Cookie[] cs=request.getCookies();
		Cookie remnameCookie=null;
		if(cs !=null){
			for(Cookie c:cs){
				if("remname".equals(c.getName())){
					remnameCookie=c;
				}
			}
		}
		String username="";
		if(remnameCookie!=null){
			username=remnameCookie.getValue();
			
			username=URLDecoder.decode(username,"utf-8");
			
		}
	%> 	
	<td class="tdx">用户名：</td>
	<td><input type="text" name="username" value="<%=username%>"/></td>
		
				</tr>
				<tr>
					<td class="tdx">密&nbsp;&nbsp; 码：</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="checkbox" name="remname" value="true"/>记住用户名
						<input type="checkbox" name="autologin" value="true"/>30天内自动登陆
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="登 陆"/>
					</td>
				</tr>
					<tr>
					<td colspan="2" style="text-align:center">${msg}</td>
				</tr>
			</table>
		</form>		
	</body>
</html>
