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

	<!--  Main part of the page from this file  to be displayed when contactus is clicked -->
	<c:if test="${userClickedContact == true }">
		<%@ include file="contact.jsp"%>
	</c:if>
	<!--  End of C-if -->

	<!--  Main part of the page from this file  to be displayed when view products or category (products) is clicked -->
	<c:if
		test="${userClickedAllProducts == true or userClickedCatgoryProducts == true}">
		<%@ include file="user_listProducts.jsp"%>
	</c:if>
	<!--  End of C-if -->

	<!--  Main part of the page from this file  to be displayed when (Admin) Product management page has been clicked-->
	<c:if
		test="${userClickedAdminProductManagement == true}">
		<%@ include file="productmanagement.jsp"%>
	</c:if>
	<!--  End of C-if -->
	<c:if
		test="${addProductFailed == true}">
		<%@ include file="productmanagement.jsp"%>
	</c:if>

	<!--  End of page cpntent-->

	<!-- Footer -->
	<%@ include file="./shared/footer.jsp"%>
	<!-- End footer -->


</body>

</html>
