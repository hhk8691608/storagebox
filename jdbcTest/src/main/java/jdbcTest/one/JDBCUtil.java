package jdbcTest.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
// jdbc:mysql://120.25.193.143:3306/app
	public static final String URL = "jdbc:mysql://120.25.193.143:3306/app?user=jiaozhen&password=jiaozhen16&useUnicode=true&characterEncoding=UTF8";
	public static final String USER = "jiaozhen";
	public static final String PASSWORD = "jiaozhen16";
	private static Connection conn = null;

	static {
		try {
			// 1.������������
			Class.forName("com.mysql.jdbc.Driver");
			// 2. ������ݿ�����
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}

	public static void main(String[] args) throws Exception {
		// 1.������������
		Class.forName("com.mysql.jdbc.Driver");
		// 2. ������ݿ�����
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		// 3.�������ݿ⣬ʵ����ɾ�Ĳ�
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT role_name, remark FROM tb_role_info");
		// ��������ݣ�rs.next()����true
		while (rs.next()) {
			System.out.println(rs.getString("role_name") + " ��ע��" + rs.getInt("remark"));
		}
	}

}
