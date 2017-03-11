<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>ElectroWorld - ${title}</title>

<script>
	window.menu = '${title}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Cyborg theme CSS -->
<link href="${css}/bootstrap-cyborg-theme.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<!--  More custom CSS  -->
<link href="${css}/styles.css" rel="stylesheet">

<!--  Datatables bootstrap CSS  -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- jQuery -->
<script src="${js}/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${js}/bootstrap.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${js}/jquery.dataTables.js"></script>

<!-- Datatable Core JavaScript -->
<script src="${js}/dataTables.bootstrap.js"></script>



<!-- My own JavaScript -->
<script src="${js}/myapp.js"></script>


</head>

<body>

	<!-- Navigation bar -->
	<%@ include file="./shared/navbar.jsp"%>
	<!-- End Navigation bar -->
	<div class="container">



		<div class="row">

			<div class="col-md-6">
				<br>
				<table class="table table-bordered" id="AllProductsTable">
					<img src="${contextRoot}/resources/images/${product.imageURL}" />
					<br>
					<br>
					<h2>${product.name}</h2>
				</table>

			</div>
			<div class="col-md-6">
				<h4>Price: ${product.price}</h4>
				<h4>Code: ${product.code }</h4>
				<h4>Supplier: ${product.suppliercode}</h4>
				<h4>Description: ${product.description}</h4>
				<div class="col-xs-3">
					<a href="${contextRoot}/customer/viewcart" class="btn btn-primary btn-block"
						role=button>View Cart</a> 
					<a href="${contextRoot}/customer/addtocart/${product.id}/product"
						class="btn btn-primary btn-block" role=button>ADD TO CART</a>
				</div>
			</div>

			<%--  <div class="col-md-6">
			<img src="${contextRoot}/resources/images/${product.imageURL}"/>
		</div> --%>




		</div>
		<%-- end of row --%>



	</div>
	<%-- End of Container --%>
</body>


</html>