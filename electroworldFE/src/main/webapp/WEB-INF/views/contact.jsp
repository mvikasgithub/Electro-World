<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<div class=container>

	<div class="row">
		<h1>Contact us</h1>
		<hr />
		<p>This our Contact us page</p>

		<%-- <img src="${contextRoot}/resources/images/contactus_map.jpg" />--%>
	</div>

	<div class="col-md-8">
		<!-- Embedded Google Map using an iframe - to select your location find it on Google maps and paste the link as the iframe src. If you want to use the Google Maps API instead then have at it! -->
		<iframe width="100%" height="400" frameborder="0" scrolling="no"
			marginheight="0" marginwidth="0"
			src="http://maps.google.com/maps?hl=en&amp;ie=UTF8&amp;ll=12.888,74.839&amp;spn=12.506174,74.013672&amp;t=m&amp;z=4&amp;output=embed"></iframe>
	</div>
	<div class="col-md-4">
		<p>
			Phone: <strong>(+91) 0824 - 2213737</strong>
		</p>
		<p>
			Email: <strong><a href="mailto:counselor@niitbejai.com">counselor@niitbejai.com</a></strong>
		</p>
		<p>
			Address: <strong>NIIT Bejai Center, 1st Floor, Pinto Chambers, Near New Baliga Stores, Bejai-Kapikad Road, Bejai, Mangalore, 575 004
			</strong>
		</p>
	</div>


</div>