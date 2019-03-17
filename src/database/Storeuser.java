package database;

import plusScreen.Newuser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

class store {
}

public class Storeuser extends store {

	public Storeuser() {

	}

	public int store(String name, String id, String pw) {
		int ct = 0;
		try {
			new DBconnect().DBSetting();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "서버와 연결이 되지 않았습니다.");
			return 0;
		}
		String query = "SELECT Name, PASSWORD FROM runninggame.user WHERE ID ='" + id + "'";
		try {
			ResultSet rs = DBconnect.stmt.executeQuery(query);
			while (rs.next()) {
				ct++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(ct>=1) {
			JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다.");
			return 0;
		}
		if (ct != 1) {
			String command = "INSERT INTO user (Name, ID, PASSWORD) VALUES";
			try {
				command += "('" + name + "','" + id + "','" + pw + "')";
				DBconnect.stmt.executeUpdate(command);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
}
