<!--  Nav bar for reuse  -->
<div class=container>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextRoot}/home"><img
					src="${images}/logo.png" alt="Your Logo"></a>
			</div>
			<!-- end navbar-header -->
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li id="home" >
						<a href="${contextRoot}/home">Home</a>
					</li>
					<li id = "about">
						<a href="${contextRoot}/about">About Us</a>
					</li>
					<li id="contact">
						<a href="${contextRoot}/contact">Contact Us</a>
					</li >
					<li id="listProducts">
						<a href="${contextRoot}/listProducts">View Products</a>
					</li>
				</ul>
				<!--  Sign up and Login glyphs will be right aligned hence navbar-right -->
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/furnitureshop/register"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="/furnitureshop/login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>
			</div>
			<!-- end of collapse navbar-collapse -->
		</div>
		<!-- end of container-fluid -->
	</nav>
	<!-- end of navbar navbar-inverse -->
</div>
<!--  end of div -->