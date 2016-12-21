<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant Registration Form</title>
<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
<form action="AddRestaurantFormServlet">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Restaurant Name</td>
                        <td><input type="text" name="restname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Restaurant Address</td>
                        <td> <textarea name="restaddress" cols="16" rows="5" ></textarea></td>
                    </tr>
                     <tr>
                        <td>Restaurant Information</td>
                        <td> <textarea name="restinfo" cols="16" rows="5" ></textarea></td>
                    </tr>
                    <tr>
                        <td>Owner Information</td>
                        <td><input type="text" name="owner_id" value="" /></td>
                    </tr>
                    
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                   
                </tbody>
            </table>
            </center>

</body>
</html>