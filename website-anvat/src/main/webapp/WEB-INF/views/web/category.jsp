<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Portfolio Item Heading -->
  <h1 class="my-4">Page Heading
    <small>Secondary Text</small>
  </h1>

	<form action="<c:url value='/productbycategory'/>" id="formSubmit01" method="get">
		<c:forEach var="item" items="${model.listResult}">
      	  <div class="row">
            <div class="col-md-7">
              <a href="<c:url value='/productdetails?code=${item.code}'/>">
                <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/700x300" alt="">
              </a>
            </div>
            <div class="col-md-5">
              <h3>${item.name}</h3>
              <p>${item.detail}</p>
              <h5>${item.price}vnđ</h5>
              <a class="btn btn-primary" href="<c:url value='/productdetails?code=${item.code}'/>">Chi tiết</a>
            </div>
          </div>
      <!-- /.row -->
      <hr>
      </c:forEach>
      <!-- Pagination -->
      <ul class="pagination" id="pagination"></ul>
      <input type="hidden" value="" id="page" name="page"/>
  	  <input type="hidden" value="" id="limit" name="limit"/>
  	  <input type="hidden" value="" id="code" name="code"/>
	</form>
      
      
      
<script type="text/javascript">
      var totalPage = ${model.totalPage};
      var currentPage = ${model.page};
       $(function () {
           window.pagObj = $('#pagination').twbsPagination({
               totalPages: totalPage,
               visiblePages: 5,
               startPage: currentPage,
               onPageClick: function (event, page) {
             	  if (currentPage != page) {
               			$('#limit').val(2);
     					$('#page').val(page);
     					$('#code').val('${code}');
     					$('#formSubmit01').submit();
     				}
               }
           });
       });
</script>
</body>
</html>