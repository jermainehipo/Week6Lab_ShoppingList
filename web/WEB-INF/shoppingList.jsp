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
        Add item: <input type="text" value="${itemtoadd}">
        <input type="submit" value="Add">
        </form>
        
        <form>
            <c:forEach var="item" items="${items}">
                <input type="radio" name="itemsinlist">
                <c:out value="${item}" /><br>
            </c:forEach>
            <input type="submit" value="Delete">
        </form>
    </body>
</html>
