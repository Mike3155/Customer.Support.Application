

<c:if test="${message}">
	<b>Welcome to our SignUp page</b>
	<br />
	
</c:if>
<form action="Register" method=get>
	<div>

		<B>SignUp</B> <br> <br> 
		<label><b>UserName</b></label> <input type="text"
		 name="ID" required> <br>
		<br> <label><b>Email</b></label> <input type="text"
		 name="email" required> <br> 
		<label><b>FirstName</b></label> <input type="name"
		name="fname" required> <br>
		<br> <label><b>LastName</b></label> <input type="name"
		name="lname" required> <br>
		<br> <label><b>Password</b></label> <input type="password"
		name="pssword" required> <br>
		<br>

		<div>
			<button type="submit" class="signup">Register</button>
		</div>
	</div>
</form>