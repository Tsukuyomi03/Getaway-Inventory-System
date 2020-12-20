
package getaway.inventory.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class class_login {
    
    static String dbURL = "jdbc:mysql://localhost:3306/getaway?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String username = "root";
    static String password = "";
    public static int login;
    public static String title;
    public static String uname;
    public static String pword;
    public static void isLoggedIn(String a)
    {
        try
        {
        Connection cn = DriverManager.getConnection(dbURL, username, password);
        PreparedStatement ps = cn.prepareStatement("SELECT * FROM users WHERE Pincode=?");
        ps.setString(1, a);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            if(rs.getString(2).equals(a))
            {
                     Connection cnc = DriverManager.getConnection(dbURL, username, password);
                     title = rs.getString(4);
                     String logger = rs.getString(4) + " has logged in.";
                     PreparedStatement sps = cnc.prepareStatement("INSERT INTO logging (Logs) Value (?)");
                     sps.setString(1, logger);
                     
                        int rowsInserted = sps.executeUpdate();
			if (rowsInserted > 0)
                        {
			       
			} 
                        new GetAwayDashboard().setVisible(true);
                        
                        login = 0;
                     break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "INVALID PIN CODE");
                login = 1;
            
            }
            
        {
            JOptionPane.showMessageDialog(null, "Username and Password is Incorrect!", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
            
        }
        
        
        
        cn.close();
        
    }
    catch (SQLException e) {
      System.out.println(e);
    }
    }
    public static void forgotpassword(String a, String b)
    {
     try
        {
        
        Connection cn = DriverManager.getConnection(dbURL, username, password);
        PreparedStatement ps = cn.prepareStatement("SELECT * FROM users WHERE Contact_No=? and Email=?");
        ps.setString(1, a);
        ps.setString(2, b);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {          
            if(rs.getString(3).equals(a) && rs.getString(4).equals(b))
            {
                    new GetAwayUpdatePassword().setVisible(true);
                    login = 0;
                    uname = rs.getString(3);
                    pword = rs.getString(4);
                    break;
            }
            else
            {
            JOptionPane.showMessageDialog(null, "Invalid Input!", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
            
          
        }
    
    }
    catch (SQLException e) {
      System.out.println(e);
    }   
    }
    public static void updatepassword(String a)
    {
     try
        {
        
        Connection cn = DriverManager.getConnection(dbURL, username, password);
        PreparedStatement ps = cn.prepareStatement("UPDATE users SET Pincode=? WHERE Contact_No=? and Email=?");
        ps.setString(1, a);
        ps.setString(2, class_login.uname);
        ps.setString(3, class_login.pword);
        
        
        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0)
        {          
                    showMessageDialog(null, "Pin Code Successfully Updated!");   
        }
        else   
        {
            JOptionPane.showMessageDialog(null, "Username and Password is Incorrect!", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
            

        
    }
    catch (SQLException e) {
      System.out.println(e);
    }   
    }
    
    
    
}
