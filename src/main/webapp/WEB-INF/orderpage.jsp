<%-- 
    Document   : orderpage
    Created on : 26-03-2018, 19:29:46
    Author     : Stephan
--%>

<%@page import="FunctionLayer.LegoHouse"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Order order = (Order) session.getAttribute("order"); %>
<% LegoHouse lh = (LegoHouse) session.getAttribute("legoHouse"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
     <style>
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
                <th><a href="FrontController?command=mainPage">Shop</a></th>
                <th><a href="FrontController?command=history">Orders</a></th>
            </tr>
        </table>
        
        <br><br>
        
        <table>
            <caption>Order overview</caption>
            <tr>
                <th>ID</th>
                <th>Length</th>
                <th>Width</th> 
                <th>Heigth</th>
                <th>Afsendt</th>
            </tr>
            <tr>
                <td><%= order.getId() %></td>
                <td><%= order.getLength() %></td>
                <td><%= order.getWidth() %></td> 
                <td><%= order.getHeigth() %></td>
                <td><%= order.isStatus() %></td> 
            </tr>           
         </table>
        <br><br>
        <table>
            <caption>Brick Distribution</caption>
            <tr>
                <th>4x1</th>
                <th>2x2</th> 
                <th>1x2</th>
            </tr>
            <tr>
                <td><%= lh.getBrickAmount(4) %></td>
                <td><%= lh.getBrickAmount(2) %></td>
                <td><%= lh.getBrickAmount(1) %></td>
            </tr>           
         </table>
    </body>
</html>
