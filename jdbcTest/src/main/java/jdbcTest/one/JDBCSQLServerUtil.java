package jdbcTest.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSQLServerUtil {
	public static final String URL = "jdbc:sqlserver://hongpu.database.chinacloudapi.cn:1433;database=honpgu";
	private static Connection conn = null;
	private static String cfn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public static final String USER = "hongpu@hongpu";
	public static final String PASSWORD = "815@azure";


	static {
		try {
			// 1.������������
			Class.forName(cfn);
			// 2. ������ݿ�����
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
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
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		try {
		conn = JDBCSQLServerUtil.getConnection();
		// 3.�������ݿ⣬ʵ����ɾ�Ĳ�
		stmt = conn.createStatement();
		 rs = stmt.executeQuery("SELECT Resume_ID, Name FROM Resume_label");
		// ��������ݣ�rs.next()����true
		while (rs.next()) {
			System.out.println(rs.getInt("Resume_ID") + " ��ע��" + rs.getString("Name"));
		}
		}catch (Exception e) {
			             e.printStackTrace();
		}finally{
		    try {
		        if(rs != null) rs.close();
		        if(stmt != null) stmt.close();
		        if(conn != null) conn.close();
		    } catch (Exception e2) {
		        // TODO: handle exception
		        e2.printStackTrace();
		    }
		}
	}

}
