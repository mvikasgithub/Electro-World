<script src="${js}/productmanagement.js"></script>
<script type="text/javascript">	
	
	
	$(function(){
		
		
		var path = window.location.href;
		if(path.indexOf('edit') > -1) {		
			$('#updatemodal').modal('show');
		}	
			
	});
	
	
</script>

<div class="container">
	<div class="row">

		<!--  Display the actual products -->
		<div class="col-md-12">

			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickedAllProducts == true}">

						<!--  Adding breadcrumb component -->
						<ol class="breadcrumb">
							<li><a href={contextRoot}/home">Home</a></li>
							<li class="active">Admin</li>
							<li class="active">All Products</li>
							
						</ol>

					</c:if>
					<!--  End of C:if  -->

					<c:if test="${userClickedCatgoryProducts == true}">

						<!--  Adding breadcrumb component -->
						<ol class="breadcrumb">
							<li><a href={contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>

					</c:if>
					<!--  End of C:if  -->
				</div>
				<!--  End of col-lg-12 -->
			</div>
			<!--  End of row -->
			
			<%-- insert code for Table here --%>
			
			<div class="row">
				<div class="container">
					<h2>Products</h2>
					<p>List of All products:</p>
					<table class="table table-bordered" id="ProductManagementTable">
						<thead>
							<tr>
								<th>Code</th>
								<th>Catergory ID</th>
								<th>Quantity</th>
								<th>Supplier Code</th>
								<th>Update</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Code</th>
								<th>Catergory ID</th>
								<th>Quantity</th>
								<th>Supplier Code</th>
								<th>Update</th>
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
		<%-- end of col-md-12  --%>
	</div>
	<%-- end of row --%>
</div>
<%-- End of Container (top)--%>

<%@include file="./shared/updatemodal.jsp"%>
