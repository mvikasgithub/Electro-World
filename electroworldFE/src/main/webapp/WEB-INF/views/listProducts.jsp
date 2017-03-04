<div class="container">
	<div class="row">

		<!--  Display a sidebar  -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!--  Display the actual products -->
		<div class="col-md-9">

			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickedAllProducts == true}">
					
						<!--  Adding breadcrumb component -->
						<ol class="breadcrumb">
							<li><a href={contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>

					</c:if>

					<c:if test="${userClickedCatgoryProducts == true}">
					
						<!--  Adding breadcrumb component -->
						<ol class="breadcrumb">
							<li><a href={contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>

					</c:if>


				</div>

			</div>



		</div>

	</div>

</div>
"


