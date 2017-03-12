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
	<form:form method="POST" modelAttribute="order"
		enctype="multipart/form-data" class="form-horizontal">
		<div class="container">

			<div class="container">
				<h1 class="well">Order Confirmation Form</h1>
				<div class="col-lg-12 well">
					<div class="row">
						<div class="col-sm-12">
							<form>
								<div class="form-group">
									<label>Order ID: </label>
									<form:input type="text" path="id" class="form-control"
										disabled="true" />
								</div>
								<div class="form-group">
									<label>User ID: </label>
									<form:input type="text" path="userid" class="form-control"
										disabled="true" />
								</div>
								<div class="form-group">
									<label>Total Items: </label>
									<form:input type="text" path="totalitems" class="form-control"
										disabled="true" />
								</div>
								<div class="form-group">
									<label>Total Value of Items: </label>
									<form:input type="text" path="totalvalue" class="form-control"
										disabled="true" />
								</div>
								<div class="form-group">
									<label>Billing Address: </label>
									<form:input type="text" path="billingaddress"
										class="form-control" disabled="true" />
								</div>
								<div class="form-group">
									<label>Shipping Address: </label>
									<form:input type="text" path="shippingaddress"
										class="form-control" disabled="true" />
								</div>
								<div class="form-group">
									<label>Shipping Address: </label>
									<form:input id="shippingaddress" type="text"
										path="shippingaddress" class="form-control" disabled="true" />
								</div>
							<input type="submit" name= "_eventId_submit" class="btn btn-default" role="button" value="Submit" />
							<input type="submit" name= "_eventId_edit" class="btn btn-default" role="button" value="Edit" />

							</form>
						</div>
					</div>

				</div>
			</div>
	</form:form>
</body>
</html>
