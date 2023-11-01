<%@ page contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous"
    >

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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>