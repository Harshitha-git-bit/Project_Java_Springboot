<%@taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
	<link rel="stylesheet" href="/css/style.css">
</head>	
<body>
	<div class="logo">
		<img src="<c:url value="/images/amazon.in logo.jpg"/>" width="120" height="60" >
	</div>
	
	<div class="signin" >
	<form >
	<h1 style="font-family:Arial;font-size:28px">Sign in</h1>
	
	<label><b>Email or mobile phone number</b></label><br><input type="text" name="email_mobile" style="height:31px;width:260px">
	<br>
	<br>
	<button type="submit" id="button_continue" >Continue</button>
	<br>
	<p>By continuing, you agree to Amazon's Conditions of <br>Use and Privacy Notice.</p>
	<p style="color:grey">______________ <sub>New to Amazon?</sub> _____________</p>
	<button type="submit" id="button_account">Create your Amazon account</button>

    </form>
	</div>
	
</body>

</html>