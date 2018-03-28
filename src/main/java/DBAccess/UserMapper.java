package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            while (ids.next()) {
                int id = ids.getInt( 1 );
                user.setId( id );
            }
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void updateOrderStatus(int id) throws LoginSampleException {
        String SQL = "UPDATE orders "
                   + "SET status = ? "
                   + "WHERE id = ?";
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static Order setOrder(int length, int width, int heigth, int userId) throws LoginSampleException {
        String SQL = "INSERT INTO orders (length, width, heigth, status, userId) "
                   + "VALUES (?, ?, ?, false, ?)";
        try {
            Connection con = Connector.connection();    
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, length);
            ps.setInt(2, width);
            ps.setInt(3, heigth);
            ps.setInt(4, userId);
            ps.executeUpdate();
            
            Order order = new Order();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.first()) {
                order.setLength( length );
                order.setWidth( width );
                order.setHeigth( heigth );
                order.setStatus( false );
                order.setUserId( userId );
                order.setId( rs.getInt(1) );
            }
            return order;
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static Order getOrder(int id) throws LoginSampleException {
        String SQL = "SELECT * FROM orders "
                   + "WHERE id=?";
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.first()) {
                Order order = new Order();
                order.setId( id );
                order.setLength( rs.getInt( "length" ));
                order.setWidth( rs.getInt( "width" ));
                order.setHeigth( rs.getInt( "heigth" ));
                order.setStatus( rs.getBoolean( "status" ));
                return order;
                
            } else {
                throw new LoginSampleException("Could not validate order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static List<Order> getOrdersByUserId(int id) throws LoginSampleException {
        List<Order> orders = new ArrayList<>();

        String SQL = "SELECT * FROM orders "
                    + "WHERE userId = ?";
        try {
            Connection con = Connector.connection();
            PreparedStatement pStmt = con.prepareStatement( SQL ); 
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setId( rs.getInt( "id" ) );
                order.setLength( rs.getInt( "length" ));
                order.setWidth(rs.getInt("width"));
                order.setHeigth(rs.getInt("heigth"));
                order.setStatus(rs.getBoolean("status"));
                orders.add(order);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return orders;
    }

    public static List<Order> getAllOrders() throws LoginSampleException {
        List<Order> orders = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setLength(rs.getInt("length"));
                order.setWidth(rs.getInt("width"));
                order.setHeigth(rs.getInt("heigth"));
                order.setStatus(rs.getBoolean("status"));
                orders.add(order);
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return orders;
    }
}

