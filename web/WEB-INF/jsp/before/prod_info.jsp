<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="${pageContext.request.contextPath}/css/prodInfo.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/prod_info.js"></script>
</head>
<body>
	<%@ include file = "_head.jsp" %>
	<div id="warp">
		<div id="left">
			<div id="left_top">
				<img src="${pageContext.request.contextPath}/img/${prodInfo.imgurl }"/>
			</div>
			<div id="left_bottom">
				<img id="lf_img" src="${pageContext.request.contextPath}/img/upload/1/0/c/f/1/d/1/6/4ff2cce6-a722-4408-ba94-0af91e61467d_c987f2c1-4123-4d87-83bd-fe2fb221e272.jpg" width="60px" height="60px" border=0/>
				<img id="mid_img" src="${pageContext.request.contextPath}/img/${prodInfo.imgurl }" width="60px" height="60px" border=0/>
				<img id="rt_img" src="${pageContext.request.contextPath}/img/upload/2/1/0/3/f/0/3/5/2fb0b43b-4dbe-440b-899b-13c02a9f5475_22d124c9-df52-4cd4-88b3-691005f1cafe.jpg" width="60px" height="60px" border=0/>
			</div>
		</div>
	<form action="${pageContext.request.contextPath}/cart/cartadd"  method="post">
		<div id="right">
			<div id="right_top">
				<span id="prod_name">${prodInfo.name } <br/></span>
				<br>
				<span id="prod_desc">${prodInfo.description }<br/></span>
			</div>
			<div id="right_middle">
				<span id="right_middle_span">
					比特币 价：
				<span class="price_red">${prodInfo.price}万亿元
				<br/>
			    运&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费：满 100 免运费<br />
			    服&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：由肖肖负责发货，并提供售后服务<br />
			    购买数量：
	            <a href="javascript:void(0)" id="delNum" onclick="delNum()">-</a>
	            <input type="text" id="buyNumInp" name="buyNum" value="1">
		        <a href="javascript:void(0)" id="addNum" onclick="addNum()">+</a>
			</div>
			<div id="right_bottom">
				<input type="hidden" name="pid" value="${prodInfo.id }"/>
				<input class="add_cart_but" type="submit" value=""/>
			</div>
		</div>
	</form>
	</div>
	<%@ include file = "_foot.jsp" %>
</body>
</html>