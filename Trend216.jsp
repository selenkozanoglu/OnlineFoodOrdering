<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/NavigationBar.css" />
<title>Trend 216</title>
</head>
<body>
<sql:setDataSource var="myDC" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/sangFood"
     user="root"  password="1234"/>

<sql:query dataSource="${myDC}" var="list_menu">
SELECT * from rest_foods   where restaurant_id ='4';
</sql:query>
<ul>
  <li><a class="active" href="index.jsp">Home</a></li>
  <li><a href="#restaurantinfo">Restaurant Information</a></li>

</ul>
 <div align="center">
        <table border="1" cellpadding="5">
            <caption><h1>Our Menu</h1></caption>
            <tr>
                <th><h2>Restaurant ID</h2></th>
                <th><h2>Food Name</h2></th>
                <th><h2>Food Type</h2></th>
                <th><h2>Price</h2></th>
            </tr>
            <c:forEach var="foods" items="${list_menu.rows}">
                <tr>
                    <td><b><h1><c:out value="${foods.restaurant_id}" /></h1></b> </td> 
                    <td><b><h1><c:out value="${foods.food_name}" /></h1></b> </td>
                    <td><b><h1><c:out value="${foods.food_type}" /></h1></b></a></td>
                    <td><b><h1><c:out value="${foods.price}" /></h1></b></a></td>
                    <td><a href="MyBasket.jsp"><button type="button">Add Basket</button></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>