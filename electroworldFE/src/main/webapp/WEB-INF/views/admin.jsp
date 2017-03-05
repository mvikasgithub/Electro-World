<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!--  So that spring can use spring form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

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
<link href="${css}/bootstrap.min.css" rel="stylesheet" />


<!-- Bootstrap Cyborg theme CSS -->
<link href="${css}/bootstrap-cyborg-theme.css" rel="stylesheet" />

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet" />

<!--  More custom CSS  -->
<link href="${css}/styles.css" rel="stylesheet" />

<!-- Bootstrap min.js -->
<script src="${js}/jquery.js"></script>

<!-- Bootstrap min.js -->
<script src="${js}/bootstrap.min.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>

<body>
	<div class="col-md-3">

		<!--  No need to load the sidebar for admin page - leaving space just in case -->

	</div>

	<div class="col-md-9">

		<div class="row">
			<div class="col-lg-12">

				<!--  Adding breadcrumb component -->
				<ol class="breadcrumb">
					<li><a href="{contextRoot}/home">Home</a></li>
					<li class="active">Admin</li>
				</ol>
			</div>
			<!--  end col-lg-12 -->

		</div>
		<!--  end row -->
		<div class="container">
			<div class="dropdown">
				<h2>Add/Update Items</h2>
				<p>Use the following options to Add/Delete/Update Products</p>
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Select Operation <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">

					<!--  Need to use ${productadminoptions} can use c:foreach -->
					<%-- JSP Commenting --%>
					<c:forEach items="${productadminoptions}" var="option">
						<li><a href="#" data-target="#${option}" data-toggle="modal">${option}</a></li>
					</c:forEach>

				</ul>
			</div>
			<!--  end of dropdown -->

			<!-- Modal -->
			<form:form method="POST" modelAttribute="product"
				class="form-horizontal" action="${contextRoot}/save/product">

				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Product Details</h4>
							</div>
							<div class="modal-body">
								<!--  <div class="form-group" type="hidden">
								<label for="ProductID">ID:</label> <input type="text"
									class="form-control" id="ProductID">
							</div>  -->
								<div class="form-group">
									<label for="ProductCode">Code:</label> <input type="text"
										class="form-control" id="ProductCode">
								</div>
								<div class="form-group">
									<label for="ProductQuantity">Quantity:</label> <input
										type="text" class="form-control" id="ProductQuantity">
								</div>
								<div class="form-group">
									<label for="ProductSupplierCode">Supplier Code:</label> <input
										type="text" class="form-control" id="ProductSupplierCode">
								</div>
								<div class="form-group">
									<label for="ProductImage">Image URL:</label> <input type="text"
										class="form-control" id="ProductImage">
								</div>
								<div class="checkbox">
									<label><input type="checkbox" value="">In Stock</label>
								</div>
								<div class="checkbox">
									<label><input type="checkbox" value="">Active</label>
								</div>
							</div>
							<div class="modal-footer">
								<!--  On clicking the Add product button invoke the /save/product page 
							<button type="button" class="btn btn-default" href="${contectRoot}/save/product"
								data-dismiss="modal">Add Product</button> -->
								<a href="#" class="btn btn-default"
									href="${contectRoot}/save/product" data-dismiss="modal"
									role="button">Add Product</a>
							</div>
						</div>

					</div>
				</div>
			</form:form>

		</div>
		<!--  end of container -->
	</div>
	<!--  end of col-md-9 -->

</body>

</html>