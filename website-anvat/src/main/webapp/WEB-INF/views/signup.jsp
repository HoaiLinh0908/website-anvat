<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="userAPI" value="/api/user"/>
<c:url var="login" value="/dang-nhap"/>
<c:url var="signup" value="/dang-ky"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">

<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
    	<c:if test="${not empty message}">
			<div class="alert alert-${alert}">
  				${message}
			</div>
		</c:if>
    	<form action="<c:url value='/j_spring_security_check'/>" id="formSignup" method="post">
			<h2>Welcome to Anvat DaNang <small>Sign up</small></h2>
			<hr class="colorgraph">
			<div class="form-group">
				<input type="text" name="fullName" id="fullName" class="form-control input-lg" placeholder="Full Name" tabindex="3">
			</div>
			<div class="form-group">
				<input type="text" name="userName" id="userName" class="form-control input-lg" placeholder="User Name" tabindex="3">
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="5">
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="6">
					</div>
				</div>
			</div>
			<div class="form-group">
				<input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email" tabindex="4">
			</div>
			<div class="form-group">
				<input type="text" name="address" id="address" class="form-control input-lg" placeholder="Address" tabindex="4">
			</div>
			<div class="form-group">
				<input type="tel" name="phoneNumber" id="phoneNumber" class="form-control input-lg" placeholder="Phone Number (0123-456-789)" tabindex="4" pattern="[0-9]{4}[0-9]{3}[0-9]{3}" required>
			</div>
			<div class="row">
				
				<div class="col-xs-8 col-sm-9 col-md-9">
					 By clicking <strong class="label label-primary">Sign Up</strong>, you agree to the <a href="#" data-toggle="modal" data-target="#t_and_c_m">Terms and Conditions</a> 
				</div>
			</div>
			<input type="hidden" name="status" id="status" value="1">
			<input type="hidden" name="roleCode" id="roleCode" value="USER">
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-md-6"><input type="button" value="Sign Up" id="btnAddUser" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
				<div class="col-xs-12 col-md-6"><a href="<c:url value='/dang-nhap' />" class="btn btn-success btn-block btn-lg">Log In</a></div>
			</div>
		</form>
	</div>
</div>
<!-- Modal -->

</div>

<script>
$('#btnAddUser').click(function (e) {
    e.preventDefault();
    var data = {};
    var formData = $('#formSignup').serializeArray();
    $.each(formData, function (i, v) {
        data[""+v.name+""] = v.value;
    });
    	addNew(data);
});

function addNew(data) {
	$.ajax({
        url: '${userAPI}',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {
        	window.location.href = "${signup}?message=signup_success";
        },
        error: function (error) {
        	window.location.href = "${signup}?message=signup_fail";
        }
    });
}
</script>
</body>
</html>