<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username} <a href="">Logout</a>
        <h2>List</h2>
        <form method="post" action="ShoppingList">
        Add item: <input type="text" value="${item}">
        <input type="submit" value="Add">
        </form>
        
        <c:forEach var="item" items="${list}">
            
            <input type='radio' name='shoppinglist' value='${item}'>${item}<br>
        </c:forEach>
            
    </body>
</html>
