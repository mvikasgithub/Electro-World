
<!-- Add Modal -->
<form:form method="POST" modelAttribute="product"
	class="form-horizontal" action="${contextRoot}/admin/save/product">

	<div class="modal fade" id="updatemodal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Update Product Details</h4>
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
						<label for="ProductQuantity">Quantity:</label>
						<form:input type="text" path="quantity" class="form-control"
							id="ProductQuantity" />
						<div class="has-error">
							<form:errors path="quantity" class="help-inline" />
						</div>
					</div>
					<div class="form-group">
						<label for="ProductSupplierCode">Supplier Code:</label>
						<form:input type="text" path="suppliercode" class="form-control"
							id="ProductSupplierCode" />
						<div class="has-error">
							<form:errors path="suppliercode" class="help-inline" />
						</div>
					</div>
					<div class="form-group">
						<label for="ProductImageURL">Image URL:</label>
						<form:input type="text" path="imageURL" class="form-control"
							id="ProductImageURL" />
						<div class="has-error">
							<form:errors path="imageURL" class="help-inline" />
						</div>
					</div>
					<div class="checkbox">
						<label><input type="checkbox" value="">In Stock</label>
					</div>
					<div class="checkbox">
						<label><input type="checkbox" value="">Active</label>
					</div>
				</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-default" role="button"
						value="UpdateProduct" />
				</div>
			</div>

		</div>
	</div>
</form:form>
<!--  End of Add Modal -->
