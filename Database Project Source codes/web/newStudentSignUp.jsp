<%-- 
    Document   : newStudentSignUp
    Created on : Dec 14, 2016, 1:57:27 PM
    Author     : nafeedgbhs
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student Sign Up</title>
    </head>
    <body>
        <jsp:include page="navigation.jsp" /> 
        <h1>New Student Sign Up</h1>
        <form method="post" action="NewStudentSignUp.do">
            Username <input type="text" name="username" /> <br/>
            Password <input type="password" name="pass" /> <br/>
            First Name <input type="text" name="firstName" /><br>
            Last Name <input type="text" name="lastName" /> <br/>
            Address <input type="text" name="address" /><br>
            Phone Number <input type="text" name="phoneNumber" /> <br/>
            Email Address <input type="text" name="emailAddress" /> <br/>
            Level <input type="text" name="lev" /> <br/>
            Term <input type="text" name="term" /> <br/>
            Department Name <input type="text" name="departmentName" /> <br/>
            <input type="submit" value="Sign Up!" />
        </form>
    </body>
</html>
