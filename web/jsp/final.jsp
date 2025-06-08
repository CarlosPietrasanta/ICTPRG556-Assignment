<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page import="model.Book" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thank You</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <%@include file="./header.jsp" %>

        <h2>Online Bookstore</h2>
        <hr>
        <h3>Thank you for shopping with us.</h3>

        <c:if test="${not empty requestScope.result}">
            <table>
                <tr>
                    <td>${requestScope.result}</td>
                </tr>
            </table>
        </c:if>

        <% session.invalidate();%>
        
        <%@include file="./footer.jsp" %>

    </body>
</html>