<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
  <h1>Biblio sign Form</h1>
  <form action="<%=request.getContextPath()%>/inscription" method="post">
  
   <table style="with: 100%">
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Username</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="text" name="password" /></td>
    </tr>

   </table>
   <input type="submit" value="Submit" />
   <input type="button" onclick="location.href='loginn.jsp';" value="Se Connecter" />
   
  </form>
  
 </div>
 

</body>
</html>