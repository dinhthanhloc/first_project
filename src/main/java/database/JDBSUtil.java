package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBSUtil {

	public static Connection getConnection() {
		Connection c = null;
		try {
			// Đăng kí MySQL với DriverManager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			// thông số
			String url = "jdbc:mySQL://localhost:3306/my_web";
			String user = "root";
			String password = "";

			// Tạo kết nối
			c = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;

	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
