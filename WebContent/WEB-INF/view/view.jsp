<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<a href="logout.html">Logout</a>
</head>
<body>
<form:form action="viewDept.html" modelAttribute="dept" method="post">
Enter empID:<form:input path="empid"/><br>
<input type="SUBMIT" value="SEARCH"/>
</form:form>

</body>
</html>