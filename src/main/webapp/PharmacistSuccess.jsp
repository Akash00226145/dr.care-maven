<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Patient List</h1>
<c:choose>
   	<c:when test="${!empty PatientList}">
<ul>

 <c:forEach items="${PatientList}" var="PatientList">
<li>
  <c:url value="PatientPrescripServlet" var="showUrl">
   <c:param name="id" value="${PatientList.id}"></c:param>
   </c:url>
   <a href="${showUrl}">
 <c:out value="${PatientList.email}" /></a></br>
 
 </li>
 
   
   </c:forEach>
   </ul>
   </c:when>
   </c:choose>
   
   <br/>
   <br/>
   
   <h1> Search Patient By Emergency ID:</h1>
<form action="PatientByEmid" method="post">
 <input type="text" id="emid"  name="emid" required>
 <input type="submit" value="Search">
 </form>
 
 <h3> ${message}</h3>

 <div class=patient>
 <c:choose>
   	<c:when test="${!empty patient}">
   	
  
   
  

  <h2> Patient Email: ${patient.email}</h2>
  <h2> Patient Address: ${patient.address}</h2>
  <h2> Patient Emergency ID: ${patient.EMID}</h2>
   
   
   </c:when>
   </c:choose>
 
 </div>
</body>
</html>