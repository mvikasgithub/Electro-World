<div class="container">
	<div class="row">

		<!--  Display the actual products -->
		<div class="col-md-12">

			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickedViewCart == true}">

						<!--  Adding breadcrumb component -->
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Vew Cart</li>
						</ol>
					</c:if>
					<!--  End of C:if  -->
				</div>
				<!--  End of col-lg-12 -->
			</div>
			<!--  End of row -->
		</div>
		<!--  end of col-md-12 -->
	</div>

	<c:choose>
		<c:when test="${not empty cartitemlist}">

			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Product ID</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Total Price</th>
						<th>Viw Details</th>
						<th>Checkout</th>
						<th>Remove</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartitemlist}" var="cartitems">
						<tr>
							<td>${cartitems.productid}</td>
							<td>${cartitems.quantity}</td>
							<td>&8377 ${cartitems.unitprice}</td>
							<td>&8377 ${cartitems.totalprice}</td>
							<td><a
								href="${contextRoot}/show/${cartitems.productid}/product"
								class="btn btn-primary " role=button>VIEW DETAILS</a></td>

							<td><a
								href="${contextRoot}/customer/checkout/${cartitems.productid}/product"
								class="btn btn-primary " role=button>CHECKOUT</a></td>
							<td><a
								href="${contextRoot}/customer/delete/${cartitems.productid}/product"
								class="btn btn-primary btn-danger" role=button>REMOVE FROM
									CART</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:when	test="${empty cartitemlist}">
				<center><h2>Cart is empty</h2></center> 
		</c:when>
	</c:choose>

</div>
<%-- end of container --%>

