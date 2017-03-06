
<!-- Add Modal -->
<form:form method="POST" modelAttribute="product"
	class="form-horizontal" action="${contextRoot}/admin/save/product">

	<div class="modal fade" id="Add" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add Product Details</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="ProductCode">Code:</label>
						<form:input type="text" path="code" class="form-control"
							id="ProductCode" />
						<div class="has-error">
							<form:errors path="code" class="help-inline" />
						</div>
					</div>
					<div class="form-group">
						<label for="ProductQuantity">Quantity:</label> <input type="text"
							class="form-control" id="ProductQuantity">
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
				<input type="submit"  class="btn btn-default"
						role="button" value ="Add Product"/>
				</div>
			</div>

		</div>
	</div>
</form:form>
<!--  End of Add Modal -->
