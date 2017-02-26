<%@page import="controller.GetPatientByEmid"%>
<%@page import="dao.PharmacistDAO"%>
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
		String emid1 = request.getParameter("emid");
	    Long emid=Long.parseLong(emid1)
	%>
	<jsp:useBean id="em" class="controller.GetPatientByEmid" />
	<jsp:setProperty property="emid" name="em" value="<%=emid%>" />

	<form action="PatientByEmid.jsp" method="post">
		<input type="text" id="a" name="emid"
			value='<jsp:getProperty property="emid" name="em"/>' /> 
		<input type="submit" value="submit" />
	</form>
	<jsp:getProperty name="em" property="msg" />
	<%
		if (emid!=null&&em.getPu()!=null) {
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