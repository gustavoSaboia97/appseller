<%@ page import="br.edu.infnet.appSales.model.domain.Seller" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html; charset=US-ASCII" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
    <%@include file="./head.jsp" %>

    <title>Sales APP</title>
</head>
<%@include file="./style.jsp" %>
<body>
    <div class="container">
        <%@include file="./header.jsp" %>

        <h1 class="text-center">Sellers</h1>

        <br />
        <br />

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">CPF</th>
                <th scope="col">NAME</th>
                <th scope="col">EMAIL</th>
                <th scope="col">NICKNAME</th>
                <th scope="col">IS ACTIVE</th>
                <th scope="col">QUANTITY OF PRODUCTS</th>
                <th scope="col">DELETE</th>
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
                        <td><%= seller.getProducts().size() %></td>
                        <td>
                            <button onclick="deleteEntity('seller', '<%= seller.getId() %>')">
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