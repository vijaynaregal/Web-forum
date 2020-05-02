<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUBTOPICS</title>
</head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="table-responsive">
<br/>
<br/>
<div align='center'>
<c:if test="${sessionScope.username != null}">
Current User:${currentuser} | <a href='jlogoutsession'>Logout</a>
</c:if>
<c:if test="${sessionScope.username == null}">
<a href='jloginsession'>Login</a>
</c:if>
</div>
<table  class="table table-hover table-sm table-bordered col-md-7">
    <tr>
      <th >Author</th>
      <th >Content</th>
      <th >Posted On</th>
    </tr>
    <c:forEach items="${entries}" var="entry"> 
    <tr>
    <td>${entry.author}</td>
    <td>${entry.content}</td>
    <td>${entry.date}</td>
    </tr>
    </c:forEach>
    <c:forEach items="${entries1}" var="entry1"> 
    <tr>
    <td>${entry1.name}</td>
    <td>${entry1.message}</td>
    <td>${entry1.date1}</td>
    </tr>
    </c:forEach>
</table>
<br/>
<c:if test="${sessionScope.username != null}">
<form action='jsubtopics' method='post'>        
<table class="table table-hover table-sm table-bordered col-md-7">
<tr> 

        <th>Your Name</th>
        <td> <input type='text' name='name' value='${currentuser}' readonly /></td>
        </tr>
                    <c:forEach items="${entries}" var="entry"> 
       <td> <input type='hidden' name='id' value='${ entry.id}'/></td></c:forEach>     
       
        <tr>
        <th>Reply</th>
        <td><input type='text' name='message' value= ''  /></td>
        </tr>
                <tr><td colspan="2" rowspan="1"><input type='submit' name='reply' value='Reply' /></td></tr>
        </table>
</form>
</c:if>

</div>
</body>
</html>