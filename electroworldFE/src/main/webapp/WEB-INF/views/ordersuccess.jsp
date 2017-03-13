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
	<div class="container">
		<!--  Adding breadcrumb component -->
		<ol class="breadcrumb">
			<li><a href="${contextRoot}/home">Home</a></li>
			<li class="active">Order Confirmation</li>
		</ol>

		<div class="row">
			<h1>Congrtulations !! Your order is confirmed.</h1>
			<hr />
			<p>Congratulations !! Your order has been successfully placed.
				You will receive your order in the next 5 days.
		</div>


	</div>
</body>
</html>