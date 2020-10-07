<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<h1 class="my-4">Tìm Kiếm</h1>
<form class="form-inline mb-3" action="/action_page.php">
          <input class="form-control mr-sm-1" type="text" placeholder="Search">
          <button class="btn btn-dark" type="submit"><i class='fas fa-search' style='font-size:18px'></i></button>
</form>
<div class="list-group">
	<c:forEach var="item" items="${menu}">
		<a href="<c:url value='/productbycategory?page=1&limit=2&code=${item.code}' />" class="list-group-item">${item.name}</a>
	</c:forEach>
</div>