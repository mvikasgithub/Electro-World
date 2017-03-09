<script src="${js}/user_viewallproducts.js"></script>

<div class="container">
	<div class="row">

		<!--  Display a sidebar  -->
		<div class="col-md-3">

		<%-- 	<%@include file="./shared/sidebar.jsp"%>	--%>

		</div>

		<!--  Display the actual products -->
		<div class="col-md-12">

			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickedAllProducts == true}">

						<!--  Adding breadcrumb component -->
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>

					</c:if>
					<!--  End of C:if  -->

					<c:if test="${userClickedCatgoryProducts == true}">

						<!--  Adding breadcrumb component -->
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>

					</c:if>
					<!--  End of C:if  -->
				</div>
				<!--  End of col-lg-12 -->
			</div>
			<!--  End of row -->

			<div class="row">
				<div class="container">
					<h2>Products</h2>
					<p>List of All products:</p>
					<table class="table table-bordered" id="AllProductsTable">
						<thead>
							<tr>
								<th>ID</th>
								<th>Code</th>
								<th>Catergory ID</th>
								<th>Quantity</th>
								<th>Supplier Code</th>
								<th>View</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>ID</th>
								<th>Code</th>
								<th>Catergory ID</th>
								<th>Quantity</th>
								<th>Supplier Code</th>
								<th>View</th>
								<th>Delete</th>
							</tr>
						</tfoot>
					</table>
					<%-- End of Table --%>
				</div>
				<%-- End of Table container  --%>
			</div>
			<%-- End of Second row --%>
		</div>
		<%-- End of col-md-9 --%>

	</div>
	<%-- End of row --%>


</div>
<%-- End of Container (top)--%>



