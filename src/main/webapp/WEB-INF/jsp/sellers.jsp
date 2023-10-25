<%@ page import="br.edu.infnet.appSales.model.domain.Seller" %>
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
        <h1 class="text-center">Sellers</h1>

        <br />
        <br />

        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">CPF</th>
                <th scope="col">NAME</th>
                <th scope="col">EMAIL</th>
                <th scope="col">NICKNAME</th>
                <th scope="col">IS ACTIVE</th>
            </tr>
            </thead>
            <tbody>
                <%for (Seller seller : (Collection<Seller>) request.getAttribute("sellers")) { %>
                    <tr>
                        <th scope="row"><%= seller.getId() %></th>
                        <td><%= seller.getCpf() %></td>
                        <td><%= seller.getName() %></td>
                        <td><%= seller.getEmail() %></td>
                        <td><%= seller.getNickname() %></td>
                        <td><%= seller.isActive() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>