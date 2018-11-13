import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */

            String uname = request.getParameter("email");
            String pswd = request.getParameter("password");
            //out.println("test");

            String myurl = "jdbc:mysql://localhost:3306/project";
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myurl, "root", "");
            Statement stmt = conn.createStatement();
           // out.println("test again");
            ResultSet rs = stmt.executeQuery("select * from signup");
            int flag = 0;
            while (rs.next()) {
                if (uname.equals(rs.getString(1)) && pswd.equals(rs.getString(2))) {

                    flag = 1;
                    RequestDispatcher req = request.getRequestDispatcher("index.html");
                    req.include(request, response);
                    break;
                }
            }
            if (flag == 0) {

                out.println("Login unsuccessful");

            } else {
                out.println("Login successful");
            }

            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }




}
