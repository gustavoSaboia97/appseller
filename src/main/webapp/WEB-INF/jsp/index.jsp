<%@ page contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!doctype html>
<html lang="en">
<head>
    <%@include file="./head.jsp" %>

    <title>Sales APP</title>
</head>
<body>
    <div class="container">
        <%@include file="./header.jsp" %>

        <span class="badge rounded-pill bg-primary">Seller: <%= request.getAttribute("totalOfSellers") %></span>
        <span class="badge rounded-pill bg-secondary">Product: <%= request.getAttribute("totalOfProducts") %></span>
        <span class="badge rounded-pill bg-success">Book: <%= request.getAttribute("totalOfBooks") %></span>
        <span class="badge rounded-pill bg-danger">Game: <%= request.getAttribute("totalOfGames") %></span>

        <h1 class="text-center">Welcome</h1>
    </div>

    <%@include file="./scripts.jsp" %>
</body>
</html>