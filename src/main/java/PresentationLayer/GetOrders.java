/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stephan
 */
public class GetOrders extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List orders = null;
        
        if (user.getRole().equals("employee")) {
            orders = LogicFacade.getAllOrders();
        } else {
            orders = LogicFacade.getOrdersByUserId(user.getId());
        }
        
        int length = parseInt(request.getParameter( "length" ));
        int width = parseInt(request.getParameter( "width" ));
        int heigth = parseInt(request.getParameter( "heigth" ));

        request.setAttribute( "orders", orders );
        LogicFacade.setOrder(length, width, heigth, user.getId());
        
        return "orderpage";
    }
}