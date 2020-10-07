<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <link href="<c:url value='/template/web/css/shop-homepage.css' />" rel="stylesheet">
<link href="<c:url value='/template/web/css/productdetails-style.css' />" rel="stylesheet">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
  <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />" type="text/javascript"></script>
  <script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>
  <%@include file="/common/web/header.jsp" %>
  
  <!-- Page Content -->
  <div class="container">
    <div class="row">
	  <div class="col-lg-3">
	    <%@include file="/common/web/menu.jsp" %>
	  </div>
	  <div class="col-lg-9">
       <dec:body/>
      </div>
    </div>
  </div>
  <!-- /.container -->
  
  <%@include file="/common/web/footer.jsp" %>
</body>
</html>