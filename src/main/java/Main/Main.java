/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

/**
 *
 * @author Stephan
 */
public class Main {
    public static void main(String[] args) throws LoginSampleException {
        for (Order o : LogicFacade.getOrdersByUserId(3)) {
            System.out.println(o.getId());
        }
    }
}
