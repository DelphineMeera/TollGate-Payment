import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
    
public class DisplayAllTravelHistory extends HttpServlet  
{    
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
         PrintWriter out = res.getWriter();  
         res.setContentType("text/html");  
         out.println("<html><body>");  
         try 
         {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/annamalai","root","");  
             // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
             Statement stmt = con.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from employee");  
             out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>ID</th><th>SOURCE_LOCATION</th><th>DESTINATION_LOCATION</th><th>TYPE_OF_VEHICLE</th><th>VEHICLE_NUMBER</th><th>JOURNEY_DATE</th><th>AMOUNT</th><th>NO_OF_TOLGATE</th><tr>");  
             while (rs.next()) 
             {   
                 int d = rs.getInt("id");
                 String n = rs.getString("source_location");  
                 String nm = rs.getString("destination_location"); 
                 String r = rs.getString("type_of_vehicle");
                 String a = rs.getString("vehicle_number");
                 Date b = rs.getDate("journey_date");
                 int c = rs.getInt("amount");
                 int s = rs.getInt("no_of_tolgate");   
                 out.println("<tr><td>" + d + "</td><td>" + n + "</td><td>" + nm + "</td><td>" + r + "</td><td>" + a + "</td><td>" + b + "</td><td>" + c + "</td><td>" + s + "</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  
     }  
 }  