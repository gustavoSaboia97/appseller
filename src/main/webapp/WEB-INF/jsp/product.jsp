<%@ page import="java.util.Collection" %>
<%@ page import="br.edu.infnet.appSales.model.domain.*" %>
<%@ page contentType="text/html; charset=US-ASCII" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
    <%@include file="./head.jsp" %>

    <title>Sales APP</title>
</head>
<%@include file="./style.jsp" %>
<body>
    <butto class="container">
        <%@include file="./header.jsp" %>

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
                <th scope="col">DELETE</th>
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
                    <td>
                        <button onclick="deleteEntity('product', '<%= game.getId() %>')">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
                            </svg>
                        </button>
                    </td>
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
                <th scope="col">DELETE</th>
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
                    <td>
                        <button onclick="deleteEntity('product', '<%= book.getId() %>')">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
                            </svg>
                        </button>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <%@include file="./scripts.jsp" %>
</body>
</html>