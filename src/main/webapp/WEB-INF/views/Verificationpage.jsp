<%@taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
	<link rel="stylesheet" href="/css/style.css">
</head>	
<body>
	<div class="logo">
		<img src="<c:url value="/images/amazon.in logo.jpg"/>" width="120" height="60" >
	</div>
	
	<div class="verification" >
	<form action="./authenticate" method="POST">
		
	<h1 style="font-family:Arial;font-size:28px">Verification</h1>
	
	<label><b>Enter your code here</b></label><br><input type="text" name="enter_code" style="height:31px;width:330px">
	<p style="color:red">${error}</p>
	<br>
	     A mail has been sent to your email 
	<br>
	
	<br>
	<a href="./verifycode"><button type="submit" id="button_verify">Verify</button></a>

    </form>
	</div>
	
</body>

</html>