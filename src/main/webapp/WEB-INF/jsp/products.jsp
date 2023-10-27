<%@ page import="java.util.Collection" %>
<%@ page import="br.edu.infnet.appSales.model.domain.*" %>
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

        <br />
        <br />

        <h3 class="text-center">GAMES</h3>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">TITLE</th>
                <th scope="col">DESCRIPTION</th>
                <th scope="col">PRICE</th>
                <th scope="col">QUANTITY</th>
                <th scope="col">PLATFORM NAME</th>
                <th scope="col">STUDIO NAME</th>
                <th scope="col">SELLER</th>
            </tr>
            </thead>
            <tbody>
            <%for (Game game : (Collection<Game>) request.getAttribute("games")) { %>
                <tr>
                    <th scope="row"><%= game.getId() %></th>
                    <td><%= game.getTitle() %></td>
                    <td><%= game.getDescription() %></td>
                    <td><%= game.getPrice() %></td>
                    <td><%= game.getQuantity() %></td>
                    <td><%= game.getPlatformName() %></td>
                    <td><%= game.getStudioName() %></td>
                    <td><%= game.getSeller().getName() %></td>
                </tr>
            <% } %>
            </tbody>
        </table>

        <br />
        <br />

        <h3 class="text-center">BOOKS</h3>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">TITLE</th>
                <th scope="col">DESCRIPTION</th>
                <th scope="col">PRICE</th>
                <th scope="col">QUANTITY</th>
                <th scope="col">AUTHOR NAME</th>
                <th scope="col">PUBLISHER NAME</th>
                <th scope="col">NUMBER OF PAGES</th>
                <th scope="col">SELLER</th>
            </tr>
            </thead>
            <tbody class="table-striped">
            <%for (Book book : (Collection<Book>) request.getAttribute("books")) { %>
                <tr>
                    <th scope="row"><%= book.getId() %></th>
                    <td><%= book.getTitle() %></td>
                    <td><%= book.getDescription() %></td>
                    <td><%= book.getPrice() %></td>
                    <td><%= book.getQuantity() %></td>
                    <td><%= book.getAuthorName() %></td>
                    <td><%= book.getPublisherName() %></td>
                    <td><%= book.getNumberOfPages() %></td>
                    <td><%= book.getSeller().getName() %></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>