
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="resources/css/style.css" />
<title>Change Password</title>

</head>
<body>




<form action="ChangePasswordServlet" method="post"   name="myForm">

            <center>
            <table border="1" cellpadding="5" cellspacing="2">
                <thead>
                    <tr>
                        <th colspan="2">Change Password</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Old Password</td>
                        <td><input type="password" name="oldpassword" required/></td>
                    </tr>
                    <tr>
                        <td>New Password</td>
                        <td><input type="password" name="newpassword" required/></td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td><input type="password" name="newpassword2" required/></td>
                    </tr>
                  <td>
                            <input type="submit" value="Change Password" />
                        </td>
                        <td>
                        <a href="index.jsp"><button type="button">Back to Home Page</button></a>
             </td>
                    </form>
</div>

                    
                    


</body>
</html>