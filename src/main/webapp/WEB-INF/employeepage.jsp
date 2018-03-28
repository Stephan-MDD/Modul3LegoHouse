<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
        <style>
            #note { color: lightgray; font-size: 12px; }
        </style>
    </head>
    <body>
        
        <table>
            <tr>
                <th><a href="FrontController?command=history">Orders</a></th>
            </tr>
        </table>
        
        <h1>Hello <%=request.getParameter( "email")%> </h1>
        
        <form name="order" action="FrontController" method="POST">
            <input type="hidden" name="command" value="order"> <br>

            lenght <input type="number" name="length" min="6" required=""> <br><br>
            
            width <input type="number" name="width" min="6" required=""> <br><br>
            
            heigth <input type="number" name="heigth" min="6" required=""> <br>

            <p id="note">note: lowest value 6</p><br>
            
            <input type="submit" value="order">
        </form>
        
        <% String error = (String) request.getAttribute( "error" );
          if ( error != null ) { %>
          <H4> Error!! </H4>
          <p><%= error %>
       <% }
       %>
       
    </body>
</html>
