<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript">
function confirmm(url)
{
	var res = confirm("Are you sure?");
	if (res == true)
		{
		document.location = url;
		}
	}
</script>
</head>
<body>
<div >
  
  <form action="<%=request.getContextPath()%>/BookView" method="post">
  
  <table class="table1">
    <tr>
     <td>KeyWord</td>
     <td><input type="text" name="keyword" value = "${sm.keyword}"/></td> <!-- we added value to keep the input shown -->
     <td><input type="submit" value="Search" name ="action" /></td>
    </tr>
    </table>
 
  </form>
  </div>
  <div >
  <table class="table1">
  <tr>
  <th>REF</th>
  <th>Title</th>
  <th>Author </th>
  <th>Price </th>
  </tr>
  <!-- en utilise la balise jstl , plus facile -->
  <c:forEach items = "${sm.books }"  var ="bo">
  <tr>
  <td>${bo.ref}</td>
  <td>${bo.title}</td>
  <td>${bo.author}</td>
  <td>${bo.price}</td>
  <td>
  	 <a href="BookView?action=Delete&ref=${bo.ref}">Delete</a>
  	 
  	
  </td>
  <td>
  	 <a href="BookView?action=Edit&ref=${bo.ref}">Edit</a>
  	
  </td>
  </tr>
    	
  </c:forEach>
  </table>
  </div>
  
  <div >
  
  <form action="<%=request.getContextPath()%>/BookView" method="post">
  <input type="hidden" value="${sm.mode}" name="mode">
  
  <table class="table1">
  <c:if test ="${sm.mode == 'add' }">
  
    <tr>
     <td>REF : </td>
     <td><input type="text" name="ref" value ="${sm.b.ref}"/></td>
     <td></td>
    </tr>
    </c:if>
    <c:if test ="${sm.mode == 'edit' }">
  
    <tr>
     <td>REF : </td>
     <td>${sm.b.ref}<input type="hidden" name="ref" value ="${sm.b.ref}"/></td>
     <td></td>
    </tr>
    </c:if>
    
    
     <tr>
     <td>TITLE : </td>
     <td><input type="text" name="title" value ="${sm.b.title}"/></td>
     <td></td>
    </tr>
     <tr>
     <td>AUTHOR : </td>
     <td><input type="text" name="author" value ="${sm.b.author}"/></td>
     <td></td>
    </tr>
     <tr>
     <td>PRICE : </td>
     <td><input type="text" name="price" value ="${sm.b.price}"/></td>
     <td></td>
    </tr>
    <tr>
     
    
     <td><input type="submit" value="Save" name ="action" /></td>
    </tr>
    </table>
 
  </form>
  </div>
  <div>
  ${sm.error}
  </div>

</body>
</html>