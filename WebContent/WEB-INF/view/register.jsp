<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="login.html" method="post" modelAttribute="cred">
<c:out value="${msg}"/><br>
Enter userName:<form:input path="username" required="true"/><br>
Enter password:<form:password path="password" required="true"/><br>
empid<form:input path="empid" required="true"/><br>
email<form:input path="email" required="true"/><br>
<input type="submit" value="login">
</form:form>
</body>
</html>