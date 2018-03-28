/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LegoHouse;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import static java.lang.Integer.parseInt;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stephan
 */
public class SetOrder extends Command {

    public SetOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int length = parseInt(request.getParameter( "length" ));
        int width = parseInt(request.getParameter( "width" ));
        int heigth = parseInt(request.getParameter( "heigth" ));  
        LegoHouse legoHouse = new LegoHouse( length, width, heigth);
        Order order = LogicFacade.setOrder(length, width, heigth, user.getId());  
        session.setAttribute( "order", order );
        session.setAttribute("legoHouse", legoHouse);
        return "orderpage";
    }
    
}
