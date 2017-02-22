<%@page import="controller.Getpatientdata1Bean"%>
<%@page import="dao.PatientUserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String email = request.getParameter("email");
	%>
	<jsp:useBean id="em" class="controller.Getpatientdata1Bean" />
	<jsp:setProperty property="email" name="em" value="<%=email%>" />

	<form action="patientdata1.jsp" method="post">
		<input type="text" id="a" name="email"
			value='<jsp:getProperty property="email" name="em"/>' /> 
		<input type="submit" value="submit" />
	</form>
	<jsp:getProperty name="em" property="msg" />
	<%
		if (email!=null&&em.getPu()!=null) {
	%>
	<p>
		Address:
 		<jsp:getProperty name="em" property="address" /> 
		
		</p>
	<p>
		Password:
		<jsp:getProperty name="em" property="password" /></p>
	<p>
		EMID:
		<jsp:getProperty name="em" property="emid" /></p>
	<%
		}
	%>
</body>
</html>