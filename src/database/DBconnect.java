package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnect {
	public static Connection con;
	public static Statement stmt;
	public void DBSetting() throws SQLException{
		con=DriverManager.getConnection("jdbc:mysql://10.80.161.68:3306/?autoReconnect=true&useSSL=false","root","ehgus@0907");
		stmt=con.createStatement();
	}
}