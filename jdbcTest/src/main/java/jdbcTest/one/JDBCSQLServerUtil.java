package jdbcTest.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSQLServerUtil {
// jdbc:mysql://120.25.193.143:3306/app
	public static final String URL = "jdbc:sqlserver://hongpu.database.chinacloudapi.cn:1433;database=honpgu;user=hongpu@hongpu;password=815@azure;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.chinacloudapi.cn;loginTimeout=30;";
	public static final String USER = "jiaozhen";
	public static final String PASSWORD = "jiaozhen16";
	private static Connection conn = null;

	static {
		try {
			// 1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 获得数据库连接
			conn = DriverManager.getConnection(URL);
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
		// 1.加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		// 2. 获得数据库连接
		Connection conn = JDBCSQLServerUtil.getConnection();
		// 3.操作数据库，实现增删改查
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT Resume_ID, Name FROM Resume_label");
		// 如果有数据，rs.next()返回true
		while (rs.next()) {
			System.out.println(rs.getInt("Resume_ID") + " 备注：" + rs.getString("Name"));
		}
	}

}
