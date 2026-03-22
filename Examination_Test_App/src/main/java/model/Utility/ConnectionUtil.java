package model.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
  static Connection con;
	
	static{
		
		try {
			
			FileInputStream fis = new FileInputStream("C:\\Users\\SACHIN\\eclipse-workspace\\Advance_java\\JDBC\\test_app\\src\\main\\resources\\config.properties");
			
			Properties property = new Properties();
			property.load(fis);
			String url =property.getProperty("url");
			
			con=DriverManager.getConnection(url, property);
			System.out.println("Connection done");
			 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    
    
    public static Connection getConnection() {
    	return con;
    }
    
    public static void closeConnection() throws SQLException{
    	
    	con.close();
    }
    
//	public static void main(String[] args) {
//	System.out.println(getConnection());
//}

}
