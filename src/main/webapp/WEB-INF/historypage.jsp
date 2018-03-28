<%-- 
    Document   : historypage
    Created on : 27-03-2018, 11:54:20
    Author     : Stephan
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) session.getAttribute("user"); %>
<!--% List<Order> orders = (ArrayList<Order>) request.getAttribute("orders"); %-->
<% List<Order> orders;
    if (user.getRole().equals("employee")) {
    orders = LogicFacade.getAllOrders();
} else {
    orders = LogicFacade.getOrdersByUserId(user.getId());
} %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        select {
            width: 100%;
        }    
            
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
        </style>
    </head>
    <body>
        
        <table>
            <tr>
                <th><a href="FrontController?command=shop">Shop</a></th>
            </tr>
        </table>
        
        <table>
            <caption>Order overview</caption>
            <tr>
                <th>ID</th>
                <th>Length</th>
                <th>Width</th> 
                <th>Heigth</th>
                <th>Afsendt</th>
            </tr>
            
            <% for(Order o : orders) {
                    out.println("<tr data-href='?id=" + o.getId() + "'>");
                        out.println("<td>" + o.getId() + "</td>");
                        out.println("<td>" + o.getLength()+ "</td>");
                        out.println("<td>" + o.getWidth()+ "</td>");
                        out.println("<td>" + o.getHeigth()+ "</td>");
                        
                        if (user.getRole().equals("employee")){
                            out.println("<td><select>");
                                out.println("<option value='false'>in progress</option>");
                                out.println("<option value='true'>one its way</option>");
                            out.println("</select></td>");
                        }
                        else {
                            out.println("<td>" + o.isStatus()+ "</td>");
                        }

                    out.println("</tr>");    
                } %>    
                     
         </table>
    </body>
</html>
