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
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">肖肖后台管理系统</a>
   
    
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
        	<h2>添加商品</h2>
            <input type="hidden" name="_method" value="put"/>
            </br>
            <div class="table-responsive">
                <form>
                    <div class="form-group">
                      <label for="exampleFormControlInput1">商品名称</label>
                      <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="请输入商品名称">
                    </div>
                    <div class="form-group">
                      <label for="exampleFormControlInput1">商品价格</label>
                      <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="请输入商品价格">
                    </div>
                    <div class="form-group">
                      <label for="exampleFormControlSelect1">商品类型</label>
                      <select class="form-control" id="exampleFormControlSelect1">
                        <option>电子数码</option>
                        <option>服装服饰</option>
                        <option>日用百货</option>
                        <option>床上用品</option>
                        <option>家用电器</option>
                        <option>图书杂志</option>
                      </select>
                    </div>
                    <div class="form-group">
                    	<label for="exampleFormControlTextarea1">商品图片</label>
	                    <div class="input-group mb-3">
						  <div class="custom-file">
						    <input type="file" class="custom-file-input" id="inputGroupFile02">
						    <label class="custom-file-label" for="inputGroupFile02" aria-describedby="inputGroupFileAddon02">Choose file</label>
						  </div>
					</div> 
					</div>
                    <div class="form-group">
                      <label for="exampleFormControlTextarea1">商品描述</label>
                      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="请输入商品描述"></textarea>
                    </div>
                     <button type="submit" class="btn btn-primary">修改</button>
                  </form>
            
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
