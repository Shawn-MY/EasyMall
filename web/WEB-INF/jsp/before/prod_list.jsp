<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	<link href="${pageContext.request.contextPath}/css/prodList.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="_head.jsp" %>
	<div id="content">
		<div id="search_div">
			<form method="post" action="${pageContext.request.contextPath}/prod_list/searchProd">
				<span class="input_span">商品名：<input type="text" name="name"/></span>
				<span class="input_span">商品种类：<input type="text" name="category"/></span>
				<span class="input_span">商品价格区间：<input type="text" name="minPrice"/> - <input type="text" name="maxPrice"/></span>
				<input type="submit" value="查 询">
			</form>
		</div>
		<div id="prod_content">
		<c:forEach items="${prodList}" var="prod">
			<div class="prod_div">
				<a href="#">
				<img src="${pageContext.request.contextPath}/img/${prod.imgurl }"></img>
				</a>
				<div id="prod_name_div">
					${prod.name}
				</div>
				<div id="prod_price_div">
					￥${prod.price}
				</div>
				<div>
					<div id="gotocart_div">
						<a href="${ pageContext.request.contextPath }/prod_list/prod_info?id=${prod.id }">加入购物车</a>
					</div>					
					<div id="say_div">
						666人评价
					</div>					
				</div>
			</div>
			</c:forEach>
			<div style="clear: both"></div>
		</div>
	</div>
	<%@ include file="_foot.jsp" %>
</body>
</html>
