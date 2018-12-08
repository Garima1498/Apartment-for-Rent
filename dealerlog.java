
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class dealerlog extends HttpServlet {

  
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */

            String uname = request.getParameter("email");
            String pswd = request.getParameter("password");
            //out.println("test");
            
            LoginDataBase l = new LoginDataBase();
        try {
           int result = l.checkInfo(uname, pswd);
           if(result > 0)
           {
               out.println("login successfull");
               response.sendRedirect("index_2.html");
               
           }
           else
           {
               //out.println("not correct");               response.sendRedirect("index.html");
           }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            

        
    }




}
