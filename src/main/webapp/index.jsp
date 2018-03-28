
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Lego Architecht</h1>
        <h2>Custom Designed Lego Houses</h2>
        
        <h3>Login</h3>
        <form name="login" action="FrontController" method="POST">
            <input type="hidden" name="command" value="login"> 
            
            <input type="text" name="email" placeholder="email"> <br>

            <input type="password" name="password" placeholder="password"> <br>
            
            <input type="submit" value="submit">
        </form> <br>
        
        <a href="FrontController?command=registration">No login yet? Register here.</a> <br>
        
        <% String error = (String) request.getAttribute( "error" );
           if ( error != null ) { %>
           <H4> Error!! </H4>
           <p><%= error %>
        <% }
        %>
        
    </body>
</html>
