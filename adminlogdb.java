/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class adminlogdb  {
    
    public int checkInfo(String username,String password) throws ClassNotFoundException, SQLException
    {
        String myurl = "jdbc:mysql://localhost:3306/project";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myurl, "root", "");
            Statement stmt = conn.createStatement();
           // out.println("test again");
            ResultSet rs = stmt.executeQuery("select * from adminlog");
            int flag = 0;
            while (rs.next()) {
                if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {

                    return 1;
                }
            }
          conn.close();
        return 0;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        LoginDataBase l = new LoginDataBase();
       int result = l.checkInfo("garima@gmail.com", "123");
       if(result>0)
       {
           System.out.println("login succesfull");
       }
       else
       {
           System.out.println("not correct");
       }
    }
    
}
