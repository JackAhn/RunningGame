package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Updateuser {
	
	public int update(String name, String id, String pw) {
		int ct = 0;
		try {
			new DBconnect().DBSetting();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "서버와 연결이 되지 않았습니다.");
			return 0;
		}
		if (ct != 1) {
			String command = "UPDATE runninggame.user set Name='"+name+"'WHERE ID='"+id+"'";
			String command2 = "UPDATE runninggame.user set PASSWORD='"+pw+"'WHERE ID='"+id+"'";
			try {
				DBconnect.stmt.executeUpdate(command);
				DBconnect.stmt.executeUpdate(command2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
}
