<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.websiteanvat.util.SecurityUtils" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="cartAPI" value="/api/cart"/>
<c:url var="productDetail" value="/productdetails"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
  <c:if test="${not empty message}">
	<div class="alert alert-${alert}">
  	  ${message}
	</div>
  </c:if>
<!-- Portfolio Item Heading -->
  <h1 class="my-4">${model.name}</h1>

  <!-- Portfolio Item Row -->
  <div class="row">

    <div class="col-md-8">
      <img class="img-fluid" src="http://placehold.it/750x500" alt="">
    </div>

    <div class="col-md-4">
      <h3 class="my-3">Product Details</h3>
      <p>${model.detail}</p>
      <h5 id="price">${model.price}vnđ</h5>
      <h3 class="my-3">Quantity</h3>
      <form id="quantitybox">
  		<div class="value-button" id="decrease" onclick="decreaseValue()" value="Decrease Value">-</div>
  		  <input type="number" name="quantity" id="number" value="0" />
  		<div class="value-button" id="increase" onclick="increaseValue()" value="Increase Value">+</div>
  		<input type="hidden" value="${code}" id="productCode" name="productCode"/>
	  </form>
	  <span></span>
	  <security:authorize access="isAuthenticated()">
	  <button type="button" id="btnThemVaoGio" class="btn btn-success" style="margin-top: 20px">
        Thêm vào giỏ <span class="glyphicon glyphicon-play"></span>
      </button>
      </security:authorize>
    </div>
  </div>
  <!-- /.row -->

  <!-- Related Projects Row -->
  <h3 class="my-4">Related Projects</h3>

  <div class="row">

    <div class="col-md-3 col-sm-6 mb-4">
      <a href="#">
            <img class="img-fluid" src="http://placehold.it/500x300" alt="">
          </a>
    </div>

    <div class="col-md-3 col-sm-6 mb-4">
      <a href="#">
            <img class="img-fluid" src="http://placehold.it/500x300" alt="">
          </a>
    </div>

    <div class="col-md-3 col-sm-6 mb-4">
      <a href="#">
            <img class="img-fluid" src="http://placehold.it/500x300" alt="">
          </a>
    </div>

    <div class="col-md-3 col-sm-6 mb-4">
      <a href="#">
            <img class="img-fluid" src="http://placehold.it/500x300" alt="">
          </a>
    </div>

  </div>
  <!-- /.row -->
  
<script>
$('#btnThemVaoGio').click(function (e) {
	e.preventDefault();
    var data = {};
    var formData = $('#quantitybox').serializeArray();
    $.each(formData, function (i, v) {
        data[""+v.name+""] = v.value;
    });
		data["price"] = ${model.price};
    	addNew(data);
});

function addNew(data) {
	$.ajax({
        url: '${cartAPI}',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {
        	window.location.href = "${productDetail}?message=addcart_success&code=${code}";
        },
        error: function (error) {
        	window.location.href = "${productDetail}?message=addcart_fail&code=${code}";
        }
    });
}

  function increaseValue() {
    var value = parseInt(document.getElementById('number').value, 10);
    value = isNaN(value) ? 0 : value;
    value++;
    document.getElementById('number').value = value;
  }

  function decreaseValue() {
    var value = parseInt(document.getElementById('number').value, 10);
    value = isNaN(value) ? 0 : value;
    value < 1 ? value = 1 : '';
    value--;
    document.getElementById('number').value = value;
  }
</script>
</body>
</html>