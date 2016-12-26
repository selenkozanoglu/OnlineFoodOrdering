<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="editProfile.jsp">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Edit Information</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><textarea name="Address" cols="22" rows="5" > </textarea>/></td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td><input type="tel" name="usrtel" value=""></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                   
                    <tr>
                        <td><input type="button" value="Save Changes" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>

</body>
</html>