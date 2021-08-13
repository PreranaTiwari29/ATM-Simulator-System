
package atm.simulator.system;
import java.sql.*;
 

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
           c =DriverManager.getConnection("jdbc:mysql:///bms","root",""); 
           // c=DriverManager.getConnection("jdbc:mysql:///bms?autoReconnect=true&useSSL=false","root","");
            s =c.createStatement(); 
           
          
            }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  


