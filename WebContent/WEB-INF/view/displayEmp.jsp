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
<form:form action="updateDept.html" modelAttribute="dept" method="post">
<c:if test="${!empty dept}">
empId:<form:input path="empid" value="${dept.empid}" readonly="true"/><br>
emp Name:<form:input path="empname" value="${dept.empname}"/><br>
gender:<form:input path="gender" value="${dept.gender}"/><br>
designation:<form:input path="designation" value="${dept.designation}"/><br>
salary:<form:input path="salary" value="${dept.salary}"/><br>
city:<form:input path="city" value="${dept.city}"/><br>
email id:<form:input path="emailid" value="${dept.emailid}"/><br>
mobile no:<form:input path="mobileno" value="${dept.mobileno}"/><br>
<input type="SUBMIT" name="ops" value="update"/>
<input type="SUBMIT" name="ops" value="delete"/>
</c:if>
</form:form>

</body>
</html>