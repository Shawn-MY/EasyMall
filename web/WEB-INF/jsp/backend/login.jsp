<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />

    <title>后台登录</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/backend/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/backend/signin.css" rel="stylesheet" type="text/css">
<style>
	.box{
		width: 100%;
		height: 100%;
		background-image: url("../../../img/login/bg1.jpg");
		background-repeat: no-repeat;
		background-clip: content-box;
		font-size: 100%;
	}
</style>

    
    
  </head>
  <body class="text-center">
  <div class="box">
	  <form class="form-signin" action="${pageContext.request.contextPath}/backend/login" method="POST" >
		  <img class="mb-4" src="../../../img/login/bg.jpg" width="125" height="125" style="margin-top: 200px">
		  <h1 class="h3 mb-3 font-weight-normal" style="color: white;font-family: 楷体">欢迎来到肖肖商城后台管理系统</h1>
		  <label for="inputEmail" class="sr-only">Email address</label>
		  <input name="username" type="text" id="inputEmail" class="form-control" placeholder="用户名" required autofocus>
		  <label for="inputPassword" class="sr-only">Password</label>
		  <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required>

		  <p style="color: red">${msg}</p>
		  <br />
		  <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>

		  <p class="mt-5 mb-3 text-muted">&copy; 2022</p>
	  </form>
  </div>

</body>
</html>
