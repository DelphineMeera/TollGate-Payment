import java.sql.*;  
  
public class AdminLoginDoa {  
public static boolean validate(String name,String pass){  
boolean status=false;  
 Connection con=null;
try{  
Class.forName("com.mysql.jdbc.Driver");  
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/annamalai","root","");  
              
      
PreparedStatement ps=con.prepareStatement(  
"select * from admin where name=? and password=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  