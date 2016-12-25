<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/NavigationBar.css" />
<title>Add Food To Menu</title>
</head>
<body>
<div id="message"><span style="color:black;font-weight:bold"><%
    if (null!=request.getAttribute("message"))
    {
  		out.println(request.getAttribute("message"));
    } %>
    </span></div>
<form action="EditMenuServlet" method="post">
<center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2"><h1>Menu</h1></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><h1>Food Name</h1></td>
                        <td><input type="text" name="foodname" value="" /></td>
                    </tr>
                    <tr>
                        <td><h1>Food Type</h1></td>
                        <td><input type="text" name="foodtype" value="" /></td>
                    </tr>
                    <tr>
                        <td><h1>Price</h1></td>
                        <td><input type="text" name="price" value="" /></td>
                    </tr>
                   
                    <tr>
                        <td><input type="submit" value="Add to Menu" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                   
                </tbody>
            </table>
            </center>

</form>

</body>
</html>