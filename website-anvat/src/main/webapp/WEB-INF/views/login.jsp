<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="sidenav">
         <div class="login-main-text">
            <h2><a class="navbar-brand" href="<c:url value='/trang-chu' />" style="font-size: 40px"><i class='fab fa-atlassian' style='font-size:45px'></i>nvat DaNang</a><br> Login Page</h2>
            <p>Login or register from here to access.</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
            <c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">	
							Username or password incorrect
					</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">	
							you Not authorize
					</div>
			</c:if>
               <form action="j_spring_security_check" id="formLogin" method="post">
                  <div class="form-group">
                     <label>User Name</label>
                     <input type="text" class="form-control" id="userName" name="j_username" placeholder="User Name">
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" id="password" name="j_password" placeholder="Password">
                  </div>
                  <button type="submit" class="btn btn-black">Login</button>
                  <a href="<c:url value='/dang-ky' />" class="btn btn-success">Sign up</a>
               </form>
            </div>
         </div>
      </div>
</body>
</html>