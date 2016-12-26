
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="resources/css/style.css" />
<title>Change Password</title>
 <script type="text/javascript">

function validateOldPassword(password) {
    var x = document.myForm.oldpassword.value;
    var oldpassword = password;
    if (x != oldpassword) {
     alert("Your old password is not correct");

        return false;
    }
      
    else return validateNewPassword();
    
}
function validateNewPassword() {
    var x = document.myForm.newpassword.value;
    var y = document.myForm.newpassword2.value;
    if (x != y) {
     alert("Password does not match, please enter the same password");

        return false;
    } 
    else return validateLengthControl();
}
function validateLengthControl(){
	
        if(myForm.newpassword.value.length < 6) {
            alert("Error: Password must contain at least six characters!");
            myForm.newpassword2.focus();
            return false;
          
        }
        else alert ("Password succesfully changed")
}


</script>

</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/sangFood"
     user="root"  password="1234"/>

<sql:query dataSource="${snapshot}" var="password">
select t1.password from users t1 where username = ? 
<sql:param value="${sessionScope.currentSessionUser}"/>
</sql:query>
<c:forEach var="row" items="${password.rows}">




<form action="ChangePasswordServlet" method="post"   name="myForm" onsubmit="return validateOldPassword('${row.password}') ;">

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
                        <c:choose>
                       <c:when test="${sessionScope.usertype=='1'}">
                         <a href="<c:url value="/customerLogged.jsp"/>"><button type="button">Go to Home</button></a>
                          </c:when> 
                            <c:when test="${sessionScope.usertype=='2'}">
                         <a href="<c:url value="/ManagerLogged.jsp"/>"><button type="button">Go to Home</button></a>
                          </c:when>  
                             <c:when test="${sessionScope.usertype=='3'}">
                         <a href="<c:url value="/RestaurantOwnerLogged.jsp"/>"><button type="button">Go to Home</button></a>
                          </c:when> 
                             <c:when test="${sessionScope.usertype=='4'}">
                         <a href="<c:url value="/AdminLogged.jsp"/>"><button type="button">Go to Home</button></a>
                          </c:when> 
                     </c:choose>
             </td>
                    </form></c:forEach>
                 
                    </form>
</div>



</body>
</html>
