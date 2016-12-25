<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/NavigationBar.css" />
<title>Insert title here</title>
</head>
<body>
<sql:query dataSource="${myDC}" var="list_orders">
select *, o1.user_id uid from restaurants r1 , orders o1, users u1, rest_foods rs1,
order_status os1
where 
r1.owner_id = u1.user_id and u1.username=? and o1.rest_id = r1.rid
and rs1.food_id = o1.food_id and os1.status_id = o1.order_status

<sql:param value='${sessionScope.currentSessionUser}'/>
</sql:query>
<div align="center">
        <table border="1" cellpadding="5">
            <caption><h1>Waiting Orders</h1></caption>
            <tr>
                <th><h2>Order ID</h2></th>
                <th><h2>Rest Name</h2></th>
                <th><h2>User ID</h2></th>
<th><h2>Food Name</h2></th>
<th><h2>Order Adress</h2></th>
<th><h2>Order Sum</h2></th>
<th><h2>Taken</h2></th>
<th><h2>Order Status</h2></th>

            </tr>
            <c:forEach var="orders" items="${list_orders.rows}">
                <tr>
                    <td><b><h1><c:out value="${orders.order_id}" /></h1></b> </td> 
                    <td><b><h1><c:out value="${orders.rest_name}" /></h1></b> </td>
                    <td><b><h1><c:out value="${orders.user_id}" /></h1></b></a></td>
                    <td><b><h1><c:out value="${orders.food_name}" /></h1></b></a></td>
  					 <td><b><h1><c:out value="${orders.user_address}" /></h1></b></a></td>
                     <td><b><h1><c:out value="${orders.order_sum} TL" /></h1></b></a></td>
                     
               		<td><b><h1><c:out value="${orders.status_name}" /></h1></b></a></td>       
		<td><a href="OrderTakenServlet?order_id=${orders.order_id}"><button type="button">Accept Order</button></a></td>

		

                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
