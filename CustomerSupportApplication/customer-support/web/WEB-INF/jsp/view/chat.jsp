<%--@elvariable id="sessionList" type="java.util.List<javax.servlet.http.HttpSession>"--%>
<template:basic htmlTitle="Chat" bodyTitle="Live Chat">
    <c:forEach items="${sessionList}" var="s">
        <c:out value="${s.getAttribute('username')}" />
        <c:if test="${s.id == pageContext.session.id}">&nbsp;(you)</c:if>
        <c:if test="${s.id != pageContext.session.id}">
			<input type="button" type="submit" value="/Chat">
		</c:if>
    </c:forEach>
 
</template:basic>
