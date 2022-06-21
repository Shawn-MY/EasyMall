<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />

    <title>后台主页</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/backend/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/backend/goodlist.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>

<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0" >
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">肖肖商城后台管理系统</a>
   
    
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="${pageContext.request.contextPath}/backend/exit">退出登录</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="${pageContext.request.contextPath}/backend/index">
                            <span data-feather="home"></span>
                            商品列表 <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="${pageContext.request.contextPath}/backend/orderlist">
                            <span data-feather="file"></span>
                            订单列表
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="${pageContext.request.contextPath}/backend/addprod">
                            <span data-feather="shopping-cart"></span>
                	添加商品
                        </a>
                        </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <input type="hidden" name="_method" value="put"/>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th style="width:25%">id</th>
                        <th style="width:20%">名称</th>
                        <th style="width:8%">价格</th>
                        <th style="width:8%">类型</th>
                        <th style="width:8%">卖出数</th>
                        <th style="width:16%">描述</th>
                        <th style="width:5%">详情</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allGoods}" var="product">
	                    <tr>
	                        <td>${product.id }</td>
	                        <td>${product.name }</td>
	                        <td>${product.price }</td>
	                        <td>${product.category }</td>
	                        <td>${product.pnum }</td>
	                        <td>${product.description }</td>
	                        <td>
	                            <a href="${pageContext.request.contextPath}/backend/detail?id=${product.id }" target="_blanck">详情</a>
	                        </td>
	                    </tr>
                    </c:forEach>	
                    </tbody>
                </table>
                <div style="float:right">
                	&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
					第${pageCur}页&nbsp;&nbsp;
					<c:url var="url_pre" value="/backend/index">
						<c:param name="pageCur" value="${pageCur - 1 }"/>
					</c:url>
					<c:url var="url_next" value="/backend/index">
						<c:param name="pageCur" value="${pageCur + 1 }"/>
					</c:url>
					<!-- 第一页没有上一页 -->
					<c:if test="${pageCur != 1 }">
						<a href="${url_pre}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					<!-- 最后一页，没有下一页 -->
					<c:if test="${pageCur != totalPage && totalPage != 0}">
						<a href="${url_next}">下一页</a>
					</c:if>
                </div>
            </div>
            
        </main>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../../../assets/js/vendor/popper.min.js"></script>
<script src="../../../../dist/js/bootstrap.min.js"></script>

<!-- Icons -->
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<script>
    feather.replace()
</script>

</body>
</html>
