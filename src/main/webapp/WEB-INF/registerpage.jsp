<%-- 
    Document   : registerPage
    Created on : 21-03-2018, 00:26:17
    Author     : Stephan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <h1>Registration Page</h1>
        
        <h3>Signup</h3>
        <form name="register" action="FrontController" method="POST">
            <input type="hidden" name="command" value="register">
            
            <input type="text" name="email" placeholder="email"> <br>

            <input type="password" name="password" placeholder="password"> <br>
            
            <input type="password" name="conf_password" placeholder="confirm password"> <br>
            
            <input type="submit" value="submit">
        </form> <br>
   
        <a href="FrontController?command=index">Allready signed up? Back to login</a>
        
        <% String error = (String) request.getAttribute( "error" );
           if ( error != null ) { %>
           <H4> Error!! </H4>
           <p><%= error %>
        <% }
        %>
        
    </body>
</html>
