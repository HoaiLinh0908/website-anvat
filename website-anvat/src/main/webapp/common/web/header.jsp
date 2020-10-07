<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.websiteanvat.util.SecurityUtils" %>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="<c:url value='/trang-chu'/>"><i class='fab fa-atlassian' style='font-size:24px'></i>nvat DaNang</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active mr-sm-2"><a class="nav-link" href="<c:url value='/trang-chu'/>"><i class='fas fa-home'></i>
						<span class="sr-only">(current)</span>
				</a></li>
				
				<security:authorize access="isAnonymous()">
					<li class="nav-item mr-sm-2"><a class="nav-link" href="<c:url value='/dang-nhap' />"><i class='fas fa-shopping-cart'></i></a></li>
					<li class="nav-item mr-sm-2"><a class="nav-link" href="<c:url value='/dang-nhap' />">Login</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/dang-ky' />">Sign up</a>
					</li>
				</security:authorize>

				<security:authorize access="isAuthenticated()">
					<!-- <li class="nav-item"><a class="nav-link" href="#"><i class='fas fa-user-alt'></i></a></li> -->
					<li class="nav-item mr-sm-2"><a class="nav-link" href="<c:url value='/gio-hang' />"><i class='fas fa-shopping-cart'></i></a></li>
					<li class="nav-item dropdown mr-sm-2">
      				  <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       				    <i class='fas fa-user-alt'></i>
      				  </a>
      				  <div class="dropdown-menu">
        				<a class="dropdown-item" href="#">Profile</a>
        				<a class="dropdown-item" href="#">Change Password</a>
        				<a class="dropdown-item" href="#">Help</a>
      				  </div>
    				</li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/thoat' />"><i class='far fa-share-square'></i></a>
					</li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>