<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="command" class="com.po.Product" scope="request"></jsp:useBean>

<!doctype html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />

    <title>后台主页</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/backend/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/backend/goodlist.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	<script type="text/javascript">
		function checkDel(id){
  			if(window.confirm("是否删除该商品？")){
  				window.location.href = "${pageContext.request.contextPath}/backend/delete?id="+id;
  			}
  		}
	</script>
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
            <div class="table-responsive">
                <form name="prodForm" action="${pageContext.request.contextPath}/backend/update" method="post" enctype="multipart/form-data">          
               		<div class="form-group">
                      <label for="exampleFormControlInput1">商品ID</label>
                      <input id="id" name="id" type="text" class="form-control"  value="${product.id}" readonly="readonly"/>
                    </div>
                    <div class="form-group">
                      <label for="exampleFormControlInput1">商品名称</label>
                      <input id="name" name="name"  type="text" class="form-control" value="${product.name}" />
                    </div>   
                    <div class="form-group">
                      <label for="exampleFormControlInput1">商品价格</label>
                      <input id="price" name="price"   type="text" class="form-control" value="${product.price}" />
                    </div>
                    <div class="form-group">
                      <label for="exampleFormControlInput1">商品库存</label>
                      <input id="pnum"  name="pnum" type="text" class="form-control" value="${product.pnum}"/>
                    </div>
                    <div class="form-group">
                      <label for="exampleFormControlSelect1">商品类型</label>
                      <select name="category" id="category"  class="form-control" >
                        <option value="电子数码">电子数码</option>
                        <option value="服装服饰">服装服饰</option>
                        <option value="日用百货">日用百货</option>
                        <option value="床上用品">床上用品</option>
                        <option value="家用电器">家用电器</option>
                        <option value="图书杂志">图书杂志</option>
                      </select>
                    </div>
                    <label for="exampleFormControlTextarea1">商品图片</label>
                    </br>
                    <img style="height: 218px; width: 222px; " src="${pageContext.request.contextPath}/img/${product.imgurl }"/>
                    </br>
                    <div class="form-group">
              </br>
	                    <div class="input-group mb-3">
						  <div class="custom-file">
						  	
						    <input id="logo"  name="logo"  type="file" class="custom-file-input"/>
						    <label class="custom-file-label" for="inputGroupFile02" aria-describedby="inputGroupFileAddon02">Choose file</label>
						  </div>
					</div> 
					</div>
                    <div class="form-group">
                      <label for="exampleFormControlTextarea1">商品描述</label>
                      <textarea id="description" name="description" class="form-control" rows="3" >${product.description}</textarea>
                    </div>
                    <p id="msg" style="color:red">
					  ${msg}
					</p>
                     <button style="margin-bottom:30px" type="button" onclick="checkForm()" class="btn btn-primary">保存修改</button> 
                     <a href="javascript:checkDel('${product.id }')" style="margin-bottom:30px;margin-left:30px" class="btn btn-danger">删除商品</a>
                  </form>
            		<script>
  //表单验证
			function checkForm(){
				var a1=-1,a2=-1,a3=-1,a4=-1,a5=-1,a6=-1, a7=-1;
	            if($('#id').val()==""){
	                    a1 = 0;
	            }   
                else{
                    a1 = 1;
                }
	            if($('#name').val()==""){
	                    a2 = 0;
	            }   
                else{
                    a2 = 1;
                }
                if($('#price').val()==""){
	                    a3 = 0;
	            }   
                else{
                    a3 = 1;
                }
                if($('#pnum').val()==""){
	                    a4 = 0;
	            }   
                else{
                    a4 = 1;
                }
         //       $("#category option:selected").val()
	         	if($('#category').val()==""){
	                    a5 = 0;
	            }   
                else{
                    a5 = 1;
                }
                if($('#logo').val()==""){
	                    a6 = 0;
	            }   
                else{
                    a6 = 1;
                }
                if($('#description').val()==""){
	                    a7 = 0;
	            }   
                else{
                    a7 = 1;
                }
				
			
				if(a1==1&&a2==1&&a3==1&&a4==1&&a5==1&&a7==1) {	
			//	$("p").text($('#id').val()+","+$('#name').val()+","+$('#category').val());
					document.prodForm.submit();
				}
			
				else {
			//	$("p").text($('#id').val()+"adf");
					$("p").text("请完整填写商品信息");
				}
				return true;
			}
</script>
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
