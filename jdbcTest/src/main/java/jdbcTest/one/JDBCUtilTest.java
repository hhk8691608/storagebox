package jdbcTest.one;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import jdbcTest.one.mobel.ResumeInformation;

public class JDBCUtilTest {

	public static void main(String[] args) {

		try {
			ResumeInformation resumeInformation = new ResumeInformation();

			Connection conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO Resume_label(resume_id, Name, Edu1_fraud, Work1_time_fraud, Work2_time_fraud, Work3_time_fraud,"
					+ "Work1_position_fraud, Work2_position_fraud, Work3_position_fraud)" + "values("
					+ "?,?,?,?,?,?,?,?,?)";
			// 预编译
			PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql); // 预编译SQL，减少sql执行
			// 传参
			ptmt.setInt(1, 110);
			ptmt.setString(2, resumeInformation.getName());
			ptmt.setString(3, resumeInformation.getEdu1EnterTime());
			ptmt.setString(4, resumeInformation.getEdu1GraduateTime());
			ptmt.setString(5, resumeInformation.getWork1EnterTime());
			ptmt.setString(6, resumeInformation.getWork1ExitTime());
			ptmt.setString(7, resumeInformation.getWork1CompanyName());
			ptmt.setString(8, resumeInformation.getWork1Postion());
			ptmt.setString(9, resumeInformation.getWork1Responsibility());

			// 执行
			ptmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	public static void main(String[] args) {
//
//		try {
//			ResumeInformation resumeInformation = new ResumeInformation();
//
//			Connection conn = JDBCUtil.getConnection();
//
//			// 3.操作数据库，实现增删改查
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT Resume_ID, Name FROM Resume_label");
//			// 如果有数据，rs.next()返回true
//			while (rs.next()) {
//				System.out.println(rs.getInt("Resume_ID") + " 备注：" + rs.getString("Name"));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

}
