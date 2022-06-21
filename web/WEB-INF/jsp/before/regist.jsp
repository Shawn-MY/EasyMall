<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>欢迎注册肖肖商城</title>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/regist.css"/>
		<!-- Bootstrap core CSS -->
	    <link href="${pageContext.request.contextPath}/css/backend/bootstrap.min.css" rel="stylesheet" type="text/css">
	    <!-- Custom styles for this template -->
	    <link href="${pageContext.request.contextPath}/css/backend/signin.css" rel="stylesheet" type="text/css">
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/user/register" method="POST" modelAttribute="user" name="registerForm">
			<%
			Random rand = new Random();
			int token = rand.nextInt();
			session.setAttribute("token", token);
			 %>
			 <input type="hidden" name = "token" value="<%=token%>">
			<div>
				<h2 style="padding-left: 310px;font-family: 幼圓">欢迎注册肖肖商城</h2>
			</div>

			<table style="margin-bottom: 150px">
				<tr>
					<td class="tds">用户名：</td>
					<td>
						<input type="text" id="username" name="username" value="${username}" class="required"/>
					</td>
				</tr>
				<tr>
					<td class="tds">密码：</td>
					<td>
						<input type="password" id="password" name="password" class="required"/>
					</td>
				</tr>
				<tr>
					<td class="tds">确认密码：</td>
					<td>
						<input type="password" id="password2" name="password2" class="required"/>
					</td>
				</tr>
				<tr>
					<td class="tds">昵称：</td>
					<td>
						<input type="text" id="nickname" name="nickname" class="required" value="<%=request.getParameter("nickname") == null?"":request.getParameter("nickname")%>"/>
					</td>
				</tr>
				<tr>
					<td class="tds">邮箱：</td>
					<td>
						<input  type="email" id="email" name="email" class="required" value="<%=request.getParameter("email") == null?"":request.getParameter("email")%>"/>
					</td>
				</tr>
				<tr>
					<td class="tds">验证码：</td>
					<td>
						<input type="text" id="code" class="required" name="code" value="<%=request.getParameter("code") == null?"":request.getParameter("code")%>"/>
						
						<img onclick="changeImage(this)" src="<%=request.getContextPath() %>/validateCode" />
					</td>	
				</tr>
				<tr>
					<td class="sub_td" colspan="2" class="tds">
						<input  class="btn" type="button" name="button" id="button" onclick="checkForm()" value="注册用户"/>
					</td>
				</tr>
				<tr><td colspan="2" style="text-align:center"><p id="msg">${msg}</p></td>	
				</tr>
				
			</table>
		</form>
		<script>
			
			//刷新验证码
			function changeImage(thisobj){
				thisobj.src = "${pageContext.request.contextPath}/validateCode?time="+new Date().getTime();
			}
	        //表单验证
			function checkForm(){
				var a1=-1,a2=-1,a3=-1,a4=-1,a5=-1;
				//验证姓名
	            if($('#username').val()){
	                var nameVal = $('#username').val(); //原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")
	                var regName = /[~#^$@%&!*()<>:;'"{}【】  ]/;
	                if(nameVal == "" || nameVal.length < 6 || regName.test(nameVal)){
	                    a1 = 0;
	                }
	                else{
	                    a1 = 1;
	                }
	            }
	            //验证邮箱
	            if($('#email').val()){
	                var emailVal =$('#email').val();
	                var regEmail = /.+@.+\.[a-zA-Z]{2,4}$/;
	                if(emailVal== "" || (emailVal != "" && !regEmail.test(emailVal))){
	                    a2 = 0;
	                }
	                else{
	                    a2 = 1;
	                }
	            }
	            //验证昵称
	            if($('#nickname').val()){
	                var nameVal = $('#nickname').val(); //原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")
	                var regName = /[~#^$@%&!*()<>:;'"{}【】  ]/;
	                if(nameVal == "" || nameVal.length < 4 || regName.test(nameVal)){
	                    a3 = 0;
	                }
	                else{
	                    a3 = 1;
	                }
	            }
	            //验证密码
	            if($('#password').val()){
	                var passVal = $('#password').val(); //原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")
	                var regPass = /^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$/;
	                if(passVal == "" || passVal.length < 6 || regPass.test(passVal)){
	                    a4 = 0;
	                }
	                else{
	                    a4 = 1;
	                }
	            }
	            //验证第二次密码
	            if($('#password2').val()){
	            	var pass2 = $('#password2').val();
	            	var pass = $("input[name='password']").val();
	            	if(pass2==pass && pass=='') {            
		                    a5 = 0;
	                }
	                else {
		                if(pass != pass2){	
		                	a5 = 0;
		               }
		                
		                else{
		                    a5 = 1;
		                }
	                }
	                
	            }
				
			
				if(a1==1&&a2==1&&a3==1&&a4==1&&a5==1) {	
					document.registerForm.submit();
				}
			
				else {
					$("p").text("请正确填写信息");
				}
				return true;
			}
	        //为表单元素添加失去焦点事件
	        $("form :input").blur(function(){
	            var $parent = $(this).parent();
	            $parent.find(".msg").remove(); //删除以前的提醒元素（find()：查找匹配元素集中元素的所有匹配元素）
	            //验证姓名
	            if($(this).is("#username")){
	                var nameVal = $.trim(this.value); //原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")
	                var regName = /[~#^$@%&!*()<>:;'"{}【】  ]/;
	                if(nameVal == "" || nameVal.length < 6 || regName.test(nameVal)){
	                    var errorMsg = " 长度6位以上，不包含特殊字符！";
	                    //class='msg onError' 中间的空格是层叠样式的格式
	                    $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
	                }
	                else{
	                    var okMsg=" 输入正确";
	                    
	                    $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
	                }
	            }
	            //验证邮箱
	            if($(this).is("#email")){
	                var emailVal = $.trim(this.value);
	                var regEmail = /.+@.+\.[a-zA-Z]{2,4}$/;
	                if(emailVal== "" || (emailVal != "" && !regEmail.test(emailVal))){
	                    var errorMsg = " 请输入正确的E-Mail住址！";
	                    $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
	                }
	                else{
	                    var okMsg=" 输入正确";
	                    
	                    $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
	       
	                }
	            }
	            //验证昵称
	            if($(this).is("#nickname")){
	                var nameVal = $.trim(this.value); //原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")
	                var regName = /[~#^$@%&!*()<>:;'"{}【】  ]/;
	                if(nameVal == "" || nameVal.length < 4 || regName.test(nameVal)){
	                    var errorMsg = " 长度4位以上，不包含特殊字符！";
	                    //class='msg onError' 中间的空格是层叠样式的格式
	                    $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
	                }
	                else{
	                    var okMsg=" 输入正确";
	                   
	                    $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
	                }
	            }
	            //验证密码
	            if($(this).is("#password")){
	                var passVal = $.trim(this.value); //原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")
	                var regPass = /^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$/;
	                if(passVal == "" || passVal.length < 6 || regPass.test(passVal)){
	                    var errorMsg = " 长度6位以上！";
	                    //class='msg onError' 中间的空格是层叠样式的格式
	                    $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
	                }
	                else{
	                    var okMsg=" 输入正确";
	                   
	                    $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
	                }
	            }
	            //验证第二次密码
	            if($(this).is("#password2")){
	            	var pass2 = $.trim(this.value);
	            	var pass = $("input[name='password']").val();
	            	if(pass2==pass && pass=='') {
	                		var errorMsg = " 密码不能为空！";
		                    //class='msg onError' 中间的空格是层叠样式的格式
		                    $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
	                }
	                else {
		                if(pass != pass2){	
	                		var errorMsg = " 两次输入的密码不一致！";
		                    //class='msg onError' 中间的空格是层叠样式的格式
		                    $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
		               }
		                
		                else{
		                    var okMsg=" 输入正确";
		               
		                    $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
		                }
	                }
	                
	            }
	            
	        }).keyup(function(){
	            //triggerHandler 防止事件执行完后，浏览器自动为标签获得焦点
	            $(this).triggerHandler("blur"); 
	        }).focus(function(){
	            $(this).triggerHandler("blur");
	        });
	        
	         
	        
		</script>
	</body>
</html>
