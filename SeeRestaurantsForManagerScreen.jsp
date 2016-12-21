<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/NavigationBar.css" />
<title>Restaurants</title>
</head>
<body>
<sql:setDataSource var="myDC" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/sangFood"
     user="root"  password="1234"/>

<sql:query dataSource="${myDC}" var="list_restaurants">
SELECT * from restaurants where status=1;
</sql:query>
<ul>
  <li><a href="ManagerLogged.jsp">Home</a></li>
  
</ul>
<div align="center">
        <table border="1" cellpadding="5">
            <caption><h1>Restaurants</h1></caption>
            <tr>
                <th><h2>Restaurant ID</h2></th>
                <th><h2>Restaurant Address</h2></th>
                <th><h2>Restaurant Name</h2></th>
                <th><h2>Owner ID</h2></th>
            </tr>
            <c:forEach var="restaurants" items="${list_restaurants.rows}">
                <tr>
                    <td><b><h1><c:out value="${restaurants.rid}" /></h1></b></td>
                    <td><b><h1><c:out value="${restaurants.rest_address}" /></h1></b></td>
                    <td><b><h1><c:out value="${restaurants.rest_name}" /></h1></b></td>
                    <td><b><h1><c:out value="${restaurants.owner_id}" /></h1></b></td>
                    <td> <a href="deleteRestaurantServlet"><button type="button">Delete Restaurant</button></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>