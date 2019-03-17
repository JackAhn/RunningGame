package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnect {
	public static Connection con;
	public static Statement stmt;
	public void DBSetting() throws SQLException{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false","root","1234");
		stmt=con.createStatement();
		try {
			stmt.execute("use runninggame");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
