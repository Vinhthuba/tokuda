<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 26/05/2023
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
 <c:choose>
     <c:when test="${empty product.Id}">
         <form action="products?action=create" method="post">
             <label for="name">Name:</label>
             <input type="text" name="name" id="name"> </br></br>
             <label for="author">Author:</label>
             <input type="text" name="author" id="author"> </br></br>
             <label for="price">price:</label>
             <input type="text" name="price" id="price"></br></br>
             <label for="category">Name:</label>
             <input type="text" name="category" id="category"></br></br>
             <label for="desc">desc:</label>
             <input type="text" name="desc" id="desc"></br></br>
             <label for="amount">amount:</label>
             <input type="text" name="amount" id="amount"></br></br>
             <input type="submit" value="create">
             <a href="products" class="button">Cancel</a>
         </form>
     </c:when>
     <c:otherwise>
         <form action="products?action=update" method="post">

             <input type="hidden" name="Id" value="${product.Id}">
             <label for="name">Name:</label>
             <input type="text" name="name" id="name" value="${product.name}"><br><br>



             <label for="author">Author: </label>
             <input type="text" name="author" id="author" value="${product.author}"><br><br>

             <label for="price">Price: </label>
             <input type="text" name="price" id="price" value="${product.price}"><br><br>

             <label for="category">category: </label>
             <input type="text" name="category" id="category" value="${product.category}"><br><br>

             <label for="desc">desc: </label>
             <input type="text" name="desc" id="desc" value="${product.desc}"><br><br>

             <label for="amount">amount: </label>
             <input type="text" name="amount" id="amount" value="${product.amount}"><br><br>
             <input type="submit" value="update">
             <a href="products" class="button">Cancel</a>
         </form>
         <form action="products?action=delete" method="post">
             <input type="hidden" name="Id" value = "${product.Id}">
             <input type="submit" class="button" value="Delete">
         </form>
     </c:otherwise>
 </c:choose>
</body>
</html>
