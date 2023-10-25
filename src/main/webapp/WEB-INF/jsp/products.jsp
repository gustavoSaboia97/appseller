<%@ page import="br.edu.infnet.appSales.model.domain.Product" %>
<%@ page import="br.edu.infnet.appSales.model.domain.ProductType" %>
<%@ page import="br.edu.infnet.appSales.model.domain.ProductType" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html; charset=US-ASCII" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Sales APP</title>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Products</h1>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">TITLE</th>
                <th scope="col">DESCRIPTION</th>
                <th scope="col">PRICE</th>
                <th scope="col">QUANTITY</th>
            </tr>
            </thead>
            <tbody>
            <%for (Product product : (Collection<Product>) request.getAttribute("products")) { %>
                <tr>
                    <th scope="row"><%= product.getId() %></th>
                    <td><%= product.getTitle() %></td>
                    <td><%= product.getDescription() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><%= product.getQuantity() %></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>