<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

		<!-- Navigation bar -->
		<%@ include file="./shared/navbar.jsp"%>
		<!-- End Navigation bar -->

		<!--  Page content -->

			<!--  Main part of the page from this file  to be displayed when home is clicked -->
			<c:if test="${userClickedHome == true }">
				<%@ include file="home.jsp"%>
			</c:if>
			<!--  End of C-if -->

			<!--  Main part of the page from this file  to be displayed when about is clicked -->
			<c:if test="${userClickedAbout == true }">
				<%@ include file="about.jsp"%>
			</c:if>
			<!--  End of C-if -->

			<!--  Main part of the page from this file  to be displayed when about is clicked -->
			<c:if test="${userClickedContact == true }">
				<%@ include file="contact.jsp"%>
			</c:if>
			<!--  End of C-if -->

		<!--  End of page cpntent-->

		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>
		<!-- End footer -->

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- My own JavaScript -->
		<script src="${js}/myapp.js"></script>

</body>

</html>
