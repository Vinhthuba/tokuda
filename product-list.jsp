<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 26/05/2023
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<a href="products?action=new" class="button add-button">Add new book</a>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Author</th>
        <th>Price</th>
        <th>Category</th>
        <th>Desc</th>
        <th>Amount</th>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>
                ${product.Id}
            </td>
            <td>${product.name}</td>
            <td>${product.author}</td>
            <td>${product.price}</td>
            <td>${product.category}</td>
            <td>${product.desc}</td>
            <td>${product.amount}</td>
            <td>
                <a href="products?action=edit&Id=${product.Id}" class="button">Edit</a>
                <a href="products?action=delete&Id=${product.Id}" class="button" onclick="return confirm('Are you sure you want to delete this book ?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
