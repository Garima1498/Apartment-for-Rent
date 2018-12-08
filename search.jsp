
<%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #808000;}

#customers tr:hover {background-color: #D2B48C;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #D2B48C;
    color: white;
}
</style>
</head>
<body>
<table id="customers">
    <tr>
    <th>First name : </th>
    <th>Last name : </th>
    <th> Email: </th>
    <th> Phone number: </th>
    <th>Address : </th>
    <th>Pincode: </th>
    <th>City: </th>
    <th>State:  </th>
    <th>Type: </th>
    <th>Builder:  </th>
    <th>Budget: </th>
    <th>Detail:  </th>
    </tr>
<% 
           
         try{
        
         String ptype = request.getParameter("ptype");
        
         
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project",
            "root", "");
         Statement st = con.createStatement();
         ResultSet rs;
         rs = st.executeQuery("select * from booking where ptype= '" + ptype + "' ");
          while (rs.next()){ 
           %>
           <tr>
             <td><%= rs.getString("fname") %></td>
             <td><%=rs.getString("lname") %></td>
             <td><%=rs.getString("email") %></td>
             <td><%=rs.getString("phone") %></td>
             <td><%=rs.getString("address") %></td>
             <td><%=rs.getString("pincode") %></td>
             <td> <%= rs.getString("city") %></td>
             <td><%=rs.getString("state") %></td>
             <td><%=rs.getString("btype") %></td>
             <td><%=rs.getString("ptype") %></td>
             <td><%=rs.getString("budget") %></td>
             <td><%=rs.getString("details") %></td>
             
           </tr>
           <%
         } 
         st.close();
        %>        
         </table> <%
         } catch(Exception exe){
           
                 
                   out.println(exe); %>
           
                   <a href="inbox.html" > TRY AGAIN </a> 
                   <%
                    
         }
    %>
    
    </body>
</html>

