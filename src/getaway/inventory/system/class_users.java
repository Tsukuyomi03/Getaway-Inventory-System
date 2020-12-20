package getaway.inventory.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;


public class class_users {
    static String dbURL = "jdbc:mysql://localhost:3306/getaway?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String username = "root";
    static String password = "";
    
    public static void Add_User(String a, String b, String c, String d)
    {
        try
        {
           Connection cn = DriverManager.getConnection(dbURL, username, password); 
           String sql = "INSERT INTO users (Username, Password, Contact_No, Email) VALUE (?,?,?,?)";
           PreparedStatement ps = cn.prepareStatement(sql); 
           ps.setString(1, a);
           ps.setString(2, b);
           ps.setString(3, c);
           ps.setString(4, d);

           int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) 
                        {
                            showMessageDialog(null, "USER SUCCESFULLY ADDED", "SUCCES", PLAIN_MESSAGE);
                        }
        }
        catch(SQLException ex)
        {
            showMessageDialog(null, ex);
        }
    }
    public static void Update_User(String a, String b, String c, String d)
    {
        try
        {
            Connection cn = DriverManager.getConnection(dbURL, username, password); 
           String sql = "UPDATE users SET Username=?, Password=?, Contact_No=?,Email=? WHERE Username=? or Password=? or Contact_No=? or Email=?";               
           PreparedStatement ps = cn.prepareStatement(sql);           
           ps.setString(1, a);
           ps.setString(2, b);
           ps.setString(3, c);
           ps.setString(4, d);
           ps.setString(5, a);
           ps.setString(6, b);
           ps.setString(7, c);
           ps.setString(8, d);           
           int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0)
                {
                    showMessageDialog(null, "USER SUCCESFULLY UPDATED", "SUCCES", PLAIN_MESSAGE);
                }
        }
        catch(SQLException ex)
        {
            showMessageDialog(null, ex);
        }
    }
    public static void Delete_User(String a)
    {
       try
       {
            Connection cn = DriverManager.getConnection(dbURL, username, password);
            String sql = "DELETE FROM users WHERE Username=?";
            
            PreparedStatement ps = cn.prepareStatement(sql);           
            ps.setString(1, a);                    
            int rowsDeleted = ps.executeUpdate();
                if (rowsDeleted > 0) 
                {
                    showMessageDialog(null, "USER SUCCESFULLY DELETED", "SUCCES", PLAIN_MESSAGE);
                }
       }
       catch(SQLException ex)
       {
           showMessageDialog(null, ex);
       }
    }
}
