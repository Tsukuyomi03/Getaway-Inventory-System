package getaway.inventory.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;


public class class_product {
    
    static String dbURL = "jdbc:mysql://localhost:3306/getaway?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String username = "root";
    static String password = "";
    
    public static void Add_Product(String a, String b, String c, String d)
    {
        try
        {
            Connection cn = DriverManager.getConnection(dbURL, username, password);
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM products WHERE Product_Name=? and Product_Type=? and Product_Price=?");
            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);
            
            ResultSet rs = ps.executeQuery();
            
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "Product Already Exist");
            }
            else
            {
                try
        {
            
           String sql = "INSERT INTO products (Product_Name, Product_Type, Product_Price, Remaining, Incoming, Outgoing) VALUE (?,?,?,?, ?, ?)";
           PreparedStatement psp = cn.prepareStatement(sql); 
           String wew = "0";
           psp.setString(1, a);
           psp.setString(2, b);
           psp.setString(3, c);
           psp.setString(4, d);
           psp.setString(5, wew);
           psp.setString(6, wew);

           int rowsInserted = psp.executeUpdate();
			if (rowsInserted > 0)
                        {
                            
                            showMessageDialog(null, "PRODUCT SUCCESFULLY ADDED", "SUCCES", PLAIN_MESSAGE);
                            try
                            {
                                Connection cnc = DriverManager.getConnection(dbURL, username, password);
                                String logger = class_login.title + " Added a Product with Product Name of: " + a + ", Type: " + b;
                                PreparedStatement sps = cnc.prepareStatement("INSERT INTO logging (Logs) Value (?)");
                                sps.setString(1, logger);
                     
                                int rowsInserteds = sps.executeUpdate();
                                if (rowsInserteds > 0)
                                {
				
                                 
                                }  
                        
                            }
                 
                            catch(SQLException ex)
                            {
                                System.out.println(ex);
                            }
                        }
        }
        catch(SQLException ex)
        {
            showMessageDialog(null, ex);
        }
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }   
    }
    public static void Update_Product(String a, String b, String c )
    {
        try
        {
            Connection cn = DriverManager.getConnection(dbURL, username, password); 
           String sql = "UPDATE products SET Product_Name=?, Product_Type=?, Product_Price=? WHERE Product_Name=? and Product_Type=?";               
           PreparedStatement ps = cn.prepareStatement(sql);           
           ps.setString(1, a);
           ps.setString(2, b);
           ps.setString(3, c);
           ps.setString(4, a);
           ps.setString(5, b);
           
                   
           int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0)
                {
                    showMessageDialog(null, "PRODUCT SUCCESFULLY UPDATED", "SUCCES", PLAIN_MESSAGE);
                    try
                            {
                                Connection cnc = DriverManager.getConnection(dbURL, username, password);
                                String logger = class_login.title + " Updated a Product with Product Name of: " + a + ", Type: " + b;
                                PreparedStatement sps = cnc.prepareStatement("INSERT INTO logging (Logs) Value (?)");
                                sps.setString(1, logger);
                     
                                int rowsInserteds = sps.executeUpdate();
                                if (rowsInserteds > 0)
                                {
				
                                 
                                }  
                        
                            }
                 
                            catch(SQLException ex)
                            {
                                System.out.println(ex);
                            }
                }
        }
        catch(SQLException ex)
        {
            showMessageDialog(null, ex);
        }
    }
    public static void Delete_Product(String a, String b)
    {
        try
       {
            Connection cn = DriverManager.getConnection(dbURL, username, password);
            String sql = "DELETE FROM products WHERE Product_ID=? and Product_Name=?";
            
            PreparedStatement ps = cn.prepareStatement(sql);           
            ps.setString(1, a);
            ps.setString(2, b);
            int rowsDeleted = ps.executeUpdate();
                if (rowsDeleted > 0) 
                {
                    showMessageDialog(null, "PRODUCT SUCCESFULLY DELETED", "SUCCES", PLAIN_MESSAGE);
                    try
                            {
                                Connection cnc = DriverManager.getConnection(dbURL, username, password);
                                String logger = class_login.title + " Deleted a Product with Product ID of: " + a + ", Named: " + b;
                                PreparedStatement sps = cnc.prepareStatement("INSERT INTO logging (Logs) Value (?)");
                                sps.setString(1, logger);
                     
                                int rowsInserteds = sps.executeUpdate();
                                if (rowsInserteds > 0)
                                {
				
                                 
                                }  
                        
                            }
                 
                            catch(SQLException ex)
                            {
                                System.out.println(ex);
                            }
                }
       }
       catch(SQLException ex)
       {
           showMessageDialog(null, ex);
       }
    }
    public static void Order_Product(String a, String b, String c)
    {
         try
        {
                    Connection cn = DriverManager.getConnection(dbURL, username, password); 
                    String sql1 = "UPDATE products SET Incoming=Incoming+? WHERE Product_ID=? and Product_Name=?";               
                    PreparedStatement psp = cn.prepareStatement(sql1);           
                    psp.setString(1, c);
                    psp.setString(2, a);
                    psp.setString(3, b);
                   
                    
                    int rowsUpdated = psp.executeUpdate();
                if (rowsUpdated > 0)
                {
                    showMessageDialog(null, "ORDER SUCCESSFULY", "SUCCES", PLAIN_MESSAGE);
                    try
                            {
                                Connection cnc = DriverManager.getConnection(dbURL, username, password);
                                String logger = class_login.title + " Ordered a Stocks for  Product Name of: " + a + ", Stocks Ordered: " + c;
                                PreparedStatement sps = cnc.prepareStatement("INSERT INTO logging (Logs) Value (?)");
                                sps.setString(1, logger);
                     
                                int rowsInserteds = sps.executeUpdate();
                                if (rowsInserteds > 0)
                                {
				
                                 
                                }  
                        
                            }
                 
                            catch(SQLException ex)
                            {
                                System.out.println(ex);
                            }
                }
        } 
           catch(SQLException ex)
                   {
                   showMessageDialog(null, ex);
                   }
    }
    public static void Sold_Product(String a, String b, String c)
    {
        try
        {
                    Connection cn = DriverManager.getConnection(dbURL, username, password); 
                    String sql1 = "UPDATE products SET Remaining=Remaining-?, Outgoing=Outgoing+? WHERE Product_ID=? and Product_Name=?";               
                    PreparedStatement psp = cn.prepareStatement(sql1);           
                    psp.setString(1, c);
                    psp.setString(2, c);
                    psp.setString(3, a);
                    psp.setString(4, b);
                   
                    
                    int rowsUpdated = psp.executeUpdate();
                if (rowsUpdated > 0)
                {
                    showMessageDialog(null, "SOLD SUCCESSFULY", "SUCCES", PLAIN_MESSAGE);
                    try
                            {
                                Connection cnc = DriverManager.getConnection(dbURL, username, password);
                                String logger = class_login.title + " Sold a Product with Product Name of: " + a + ", Sold Item: " + c;
                                PreparedStatement sps = cnc.prepareStatement("INSERT INTO logging (Logs) Value (?)");
                                sps.setString(1, logger);
                     
                                int rowsInserteds = sps.executeUpdate();
                                if (rowsInserteds > 0)
                                {
				
                                 
                                }  
                        
                            }
                 
                            catch(SQLException ex)
                            {
                                System.out.println(ex);
                            }
                }
        } 
           catch(SQLException ex)
                   {
                   showMessageDialog(null, ex);
                   }
    }
    public static void Recieve_Product(String a, String b)
    {
        try
        {
                    Connection cn = DriverManager.getConnection(dbURL, username, password); 
                    String sql1 = "UPDATE products SET Remaining=Remaining+Incoming, Incoming=? WHERE Product_ID=? and Product_Name=?";               
                    PreparedStatement psp = cn.prepareStatement(sql1);  
                    String wew= "0";
                    psp.setString(1, wew);
                    psp.setString(2, a);
                    psp.setString(3, b);
                   
                    
                    int rowsUpdated = psp.executeUpdate();
                if (rowsUpdated > 0)
                {
                    showMessageDialog(null, "Delivery Recied!", "SUCCES", PLAIN_MESSAGE);
                    try
                            {
                                Connection cnc = DriverManager.getConnection(dbURL, username, password);
                                String logger = class_login.title + " Recieved the delivery with Product Name of: " + a;
                                PreparedStatement sps = cnc.prepareStatement("INSERT INTO logging (Logs) Value (?)");
                                sps.setString(1, logger);
                     
                                int rowsInserteds = sps.executeUpdate();
                                if (rowsInserteds > 0)
                                {
				
                                 
                                }  
                        
                            }
                 
                            catch(SQLException ex)
                            {
                                System.out.println(ex);
                            }
                }
        } 
           catch(SQLException ex)
                   {
                   showMessageDialog(null, ex);
                   }
    }
}
