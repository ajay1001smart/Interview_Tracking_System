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
<form:form action="add1.html" method="POST" modelAttribute="dept">
enter emp name:<form:input path="empname"></form:input><br><br>
enter gender:<form:input path="gender"></form:input><br><br>
Enter designation: <form:input path="designation"></form:input><br><br>
Enter salary: <form:input path="salary"></form:input><br><br>
Enter city: <form:input path="city"></form:input><br><br>
Enter emailid: <form:input path="emailid"></form:input><br><br>
Enter mobileno: <form:input path="mobileno"></form:input><br><br>
<input type="submit" value="ADD"/>
</form:form>

</body>
</html>