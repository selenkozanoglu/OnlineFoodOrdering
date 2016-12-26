<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/NavigationBar.css" />
<title>My Orders</title>
</head>
<body>
<sql:setDataSource var="myDC" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/sangFood"
     user="root"  password="1234"/>

<sql:query dataSource="${myDC}" var="list_orders">
SELECT * from orders,rest_foods,restaurants,order_status
 where user_id=? and orders.food_id = rest_foods.food_id
and restaurants.rid = orders.rest_id and orders.order_status=order_status.status_id

<sql:param value='${sessionScope.currentSessionUser}'/>
</sql:query>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h1>My Orders</h1></caption>
            <tr>
                <th><h2>Order ID</h2></th>
                <th><h2>Restaurant Name</h2></th>
                <th><h2>USER Name</h2></th>
             
                 <th><h2>Food Name</h2></th>
 				<th><h2>Order Date</h2></th>
 				<th><h2>Order Status</h2></th>
            </tr>
            <c:forEach var="orders" items="${list_orders.rows}">
                <tr>
                    <td><b><h1><c:out value="${orders.order_id}" /></h1></b> </td> 
                    <td><b><h1><c:out value="${orders.rest_name}" /></h1></b> </td>
                    <td><b><h1><c:out value="${orders.user_id}" /></h1></b></a></td>
                   
                    <td><b><h1><c:out value="${orders.food_name}" /></h1></b></a></td>
                    <td><b><h1><c:out value="${orders.order_date}" /></h1></b></a></td>
                     <td><b><h1><c:out value="${orders.status_name}" /></h1></b></a></td>
                </tr>
            </c:forEach>

</body>
</html>