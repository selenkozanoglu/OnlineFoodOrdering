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
  <script>

	function addRow(tableID,ccode,name,status,price){
		var table = document.getElementById(tableID);
		var rowCount=table.rows.lenght;
		var row = table.insertRow(rowCount);
		var cell1 = row.insertCell(0);
		cell1.innerHTML=name;
		cell1.innerHTML+="<input type='hidden' class='input-field' name='adress' value="+ ccode+ " />"
		var cell2 = row.insertCell(1);
		cell2.innerHTML=status;
		var cell3= row.insertCell(2);
		cell3.innerHTML=price;
		cell3.innerHTML+="<input type='hidden' class='input-field' name='price' value="+ price+ " />"
		var cell4 = row.insertCell(3);
		cell4.innerHTML="<input type ='button' value='Delete Food' onclick='delRow(this)'/>";	

	
		
	}
		function delRow(i){
			
			var j = i.parentNode.parentNode.rowIndex;
			document.getElementById('dataTable').deleteRow(j);
			table.deleteRow(i);
			
		}
		function findDup(ccode,tableID){
			var table=document.getElementById(tableID);
			var len = table.rows.length;
			var row=0;
			if(len<2) return false;
			for(var i=1 ; i<table.rows.length;i++){
				
			
				var dup = (table.rows[i].cells[0].innerHTML);
			
				if(dup == ccode) {
					row=1;
					}
			}
			if(row==1) return true;
			else return false;

		}
</script>
</head>
<body>
<sql:setDataSource var="myDC" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/sangFood"
     user="root"  password="1234"/>

<sql:query dataSource="${myDC}" var="list_menu">
SELECT * from rest_foods   where restaurant_id ='?';
    <sql:param value="${param.restid}"/>
</sql:query>
    
<ul>
  <li><a class="active" href="index.jsp">Home</a></li>
  <li><a href="#restaurantinfo">Restaurant Information</a></li>

</ul>
    <form action="AddBasketServlet" method="post">	<tbody>
<table cellspacing='0' width="35%" align="center" id="dataTable" border="1" cellpadding="5"> 
	<!-- Table Header -->
	<thead>
		<tr >
		<caption><h1>My Basket</h1></caption>
			<th><h1>Food Name </h1></th>
			<th><h1>Food TYpe </h1></th>
		
			<th><h1>Price </h1></th>
			<th><h1>Operation </h1></th>
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->

	
	</tbody>
	<!-- Table Body -->


</table>	
	<label><span>&nbsp;</span><input type="submit" value="Finish Order" /></label>
</form>
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
                    <td><input type="button" value ="Add Basket" onClick="return addRow('dataTable','${foods.food_id}','${foods.food_name}','${foods.food_type}','${foods.price}');"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
