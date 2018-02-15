 <c:if test="${message}">
        <b></b><br /><br />
    </c:if>
    <form method="post" action="<c:url value="/ResetPass" />">

<table align="center"> 

<B>Resset Your Password Here:</B> <br> <br>
<tr>
<td>Username: ${pageContext.session.getAttribute('username')}</td>
<td>${un}</td>
</tr>
<tr>
<td>Old Password</td>
<td><input type='password' name='oldpass'/></td>
</tr>
<tr>
<td>New Password</td>
<td><input type='password' name='newpass'/></td>
</tr>
<tr>
<td>ReEnter Password</td>
<td><input type='password' name='renewpass'/></td>
</tr>
<tr>
<td></td>
<td><input type='submit' value="RESET"/></td>
</tr>
</table>
</form>


