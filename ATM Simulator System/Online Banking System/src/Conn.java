
import java.sql.*;
public class Conn {
	
	
	Connection c ;//for creating connection
	Statement s;//for creating statement
	
	public Conn(){
		
		try{
			
//			Class.forName(com.mysql.cj.jdbc.Driver);
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Eguzk93mjs@80");//bydefault mysql database localhost vr run hoty ani tycha port no. 3306 aste.
			s = c.createStatement();
		} 
		catch(Exception e) {
		System.out.println(e);
		}
		
		
	}

}
