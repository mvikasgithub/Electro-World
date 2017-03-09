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
	<form:form method="POST" modelAttribute="user"
		enctype="multipart/form-data" class="form-horizontal">

		<!--  Adding breadcrumb component -->
		<ol class="breadcrumb">
			<!-- for triggering webflow events using links, the eventId to be triggered is given in "href" attribute as: -->
			<li><a href={contextRoot}/home">Home</a></li>
			<li class="active">Registration</li>

		</ol>
		<!--  End of breadcrumb -->

		<div class="container">
			<h1 class="well">Registration Form</h1>
			<div class="col-lg-12 well">
				<div class="row">
					<form>
						<div class="col-sm-12">
							<div class="row">
								<div class="col-sm-6 form-group">
									<label>First Name</label> 
									<form:input type="text" path="fname" placeholder="Enter First Name Here.." class="form-control" disabled="true"/>
								</div>
								<div class="col-sm-6 form-group">
									<label>Last Name</label> 
									<form:input type="text" path="sname" placeholder="Enter Last Name Here.." class="form-control" disabled="true"/>
								</div>
							</div>
							<div class="form-group">
								<label>Email Address (wii be your username)</label> 
								<form:input type="text" path="email" placeholder="Enter Email Address Here.." class="form-control" disabled="true"/>
							</div>
							<div class="form-group">
								<label>Password</label> 
								<form:input type="password" path="password" placeholder="Enter password here..." class="form-control" disabled="true"/>
							</div>
							<div class="form-group">
								<label>Billing Address</label>
								<form:textarea path="billingaddress" placeholder="Enter Address Here.." rows="3" class="form-control"  disabled="true"/> 
							</div>
							<div class="row">
								<div class="col-sm-4 form-group">
									<label>City</label> 
									<form:input type="text"	path="city" placeholder="Enter City Name Here.." class="form-control" disabled="true"/>
								</div>
								<div class="col-sm-4 form-group">
									<label>State</label> 
									<form:input type="text" path="state" placeholder="Enter State Name Here.." class="form-control" disabled="true"/>
								</div>
								<div class="col-sm-4 form-group">
									<label>Zip</label> 
									<form:input type="text" path="zip" placeholder="Enter Zip Code Here.." class="form-control" disabled="true"/>
								</div>
							</div>
							<div class="form-group">
								<label>Phone Number</label> 
								<form:input type="text" path="phoneno"	placeholder="Enter Phone Number Here.." class="form-control" disabled="true"/>
							</div>
							<div class="form-group">
								<label>Type of User:</label>
								<form:input type="text" path="role"	placeholder="Enter Phone Number Here.." class="form-control" disabled="true"/>
							</div>
							
							<!-- for triggering webflow events using form submission, the eventId to be triggered is given in "name" attribute as:
					-->							
							<input type="submit" name= "_eventId_edit" class="btn btn-default" role="button" value="Edit" />
							<input type="submit" name= "_eventId_submit" class="btn btn-default" role="button" value="Submit" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</form:form>
</body>