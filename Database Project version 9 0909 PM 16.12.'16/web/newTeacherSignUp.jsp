<%-- 
    Document   : newTeacherSignUp
    Created on : Dec 13, 2016, 8:28:29 PM
    Author     : nafeedgbhs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Teacher Sign Up</title>
    </head>
    <body>
        <jsp:include page="commonNavigation.jsp" /> 
        <h1>New Teacher Sign Up</h1>
        <form method="post" action="NewTeacherSignUp.do">
            Username <input type="text" name="username" /> <br/>
            Password <input type="password" name="password" /> <br/>
            First Name <input type="text" name="firstName" /><br>
            Last Name <input type="text" name="lastName" /> <br/>
            Address <input type="text" name="address" /><br>
            Phone Number <input type="text" name="phoneNumber" /> <br/>
            Email Address <input type="text" name="emailAddress" /> <br/>
            Join Date <input type="text" name="joinDate" value="DD/MM/YYYY" /> <br/>
            Department Name <input type="text" name="departmentName" /> <br/>
            Rank : 
            <select id="teacherRank" name="teacherRank" >
                <option  value="lecturer">Lecturer</option>
                <option  value="assistantProfessor">Assistant Professor</option>
                <option  value="associateProfessor">Associate Professor</option>
                <option  value="Professor">Professor</option>
            </select> <br/>
            <input type="submit" value="Sign Up!" />
        </form>
    </body>
</html>
