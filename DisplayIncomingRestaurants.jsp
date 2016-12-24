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
<sql:setDataSource var="myDC" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/sangFood"
     user="root"  password="1234"/>

<sql:query dataSource="${myDC}" var="list_incomingRestaurants">
SELECT * from restaurants   where status ='0';

</sql:query>
<div align="center">
        <table border="1" cellpadding="5">
            <caption><h1>Incoming Restaurants</h1></caption>
            <tr>
                <th><h2>Restaurant ID</h2></th>
                <th><h2>Restaurant Address</h2></th>
                <th><h2>Restaurant Name</h2></th>
                <th><h2>Owner ID</h2></th>
                <th><h2>Restaurant Info</h2></th>
                
            </tr>
            <c:forEach var="comingRests" items="${list_incomingRestaurants.rows}">
                <tr>
                    <td><b><h1><c:out value="${comingRests.rid}" /></h1></b> </td> 
                    <td><b><h1><c:out value="${comingRests.rest_address}" /></h1></b> </td>
                    <td><b><h1><c:out value="${comingRests.rest_name}" /></h1></b></a></td>
                    <td><b><h1><c:out value="${comingRests.owner_id}" /></h1></b></a></td>
                    <td><b><h1><c:out value="${comingRests.rest_info}" /></h1></b></a></td>
                    <td><a href="AcceptRestaurantServlet?rid=${comingRests.rid}&act=accept"><button type="button">Accept</button></a></td>
                    <td><a href="AcceptRestaurantServlet?rid=${comingRests.rid}&act=reject"><button type="button">Reject</button></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
