<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="emp" items="${empDetails}">
	${emp.id}
	${emp.name}
	${emp.email}
	${emp.phone}
	${emp.userName}
	${emp.password}
	${emp.gender}
	
	</c:forEach>

</body>
</html>