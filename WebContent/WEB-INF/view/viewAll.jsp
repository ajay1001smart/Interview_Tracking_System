<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<a href="logout.html">Logout</a>
</head>
<body>
<c:if test="${!empty dept}">
<c:forEach items="${dept}" var="depts">
<c:out value="${depts.empid}"></c:out>
<c:out value="${depts.empname}"></c:out>
<c:out value="${depts.gender}"></c:out>
<c:out value="${depts.designation}"></c:out>
<c:out value="${depts.salary}"></c:out>
<c:out value="${depts.city}"></c:out>
<c:out value="${depts.emailid}"></c:out>
<c:out value="${depts.mobileno}"></c:out><br>
</c:forEach>
</c:if>

</body>
</html>