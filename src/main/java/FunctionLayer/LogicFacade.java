package FunctionLayer;

import DBAccess.UserMapper;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User( email, password, "customer" );
        UserMapper.createUser( user );
        return user;
    }
    
    public static Order setOrder( int length, int width, int heigth, int userId ) throws LoginSampleException {
        return UserMapper.setOrder( length, width, heigth, userId );
    }
    
    public static Order getOrder(int id ) throws LoginSampleException {
        return UserMapper.getOrder( id );
    }

    public static List<Order> getOrdersByUserId( int id ) throws LoginSampleException {
        return UserMapper.getOrdersByUserId( id );
    }
    
    public static List<Order> getAllOrders() throws LoginSampleException {
        return UserMapper.getAllOrders();
    }
}
