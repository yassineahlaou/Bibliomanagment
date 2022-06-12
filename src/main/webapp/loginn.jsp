<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="authentification.Login"%>
<%
  //Login l = (Login)request.getAttribute("log");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Biblio Login Form</h1>
  <form action="<%=request.getContextPath()%>/loginn" method="post">
  
   <table style="with: 100%">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="text" name="password" /></td>
    </tr>

   </table>
   <input type="submit" value="Submit" />
   <input type="button" onclick="location.href='inscription.jsp';" value="S'inscrire" />
   
  </form>
  
 </div>
 
</body>
</html>