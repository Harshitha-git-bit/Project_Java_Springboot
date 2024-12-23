<%@taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
	<link rel="stylesheet" href="/css/style.css">
</head>	
<body>
	<div class="logo">
		<img src="<c:url value="/images/amazon.in logo.jpg"/>" width="120" height="60" >
	</div>
	
	<div class="createaccount" >
	<form action="./doverification" method="POST">
	<h1 style="font-family:Arial;font-size:28px">Create Account</h1>
	<p style="color:red;">${addalldetailsmessage}</p>
	<label><b>Your name</b></label><br><input type="text" name="name" placeholder=" First and last name" style="height:31px;width:330px">
	<br>
	<br>
	<label><b>Email</b><br>
		<input type="text" name="email" placeholder=" Enter your email" style="height:31px;width:330px"><br>
	   
		<p style="color:red;">${addnewemailmessage}</p>
		
		<label><b>Mobile number</b></label><br>
		<select name="countrycodes" id="codes" style="width:70px;height:30px">
				<option value="India">IN +91</option>
		</select> <input type="text" name="mobile" placeholder=" Mobile number" style="height:31px;width:260px">
	<br>
	<br>
	<label><b>Password</b></label><br><input type="text" name="password" placeholder=" At least 6 characters" style="height:31px;width:330px">
	<br>
	<br>
	<p>To verify your email, we will send you a text <br>message with a temporary code. Message and data <br> rates may apply.</p>
	
	<a href="./verifymobile"><button type="submit" id="button_verifymobile">Verify email id </button></a>

    </form>
	</div>
	
</body>

</html>