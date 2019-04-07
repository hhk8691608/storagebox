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
			// Ԥ����
			PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql); // Ԥ����SQL������sqlִ��
			// ����
			ptmt.setInt(1, 110);
			ptmt.setString(2, resumeInformation.getName());
			ptmt.setString(3, resumeInformation.getEdu1EnterTime());
			ptmt.setString(4, resumeInformation.getEdu1GraduateTime());
			ptmt.setString(5, resumeInformation.getWork1EnterTime());
			ptmt.setString(6, resumeInformation.getWork1ExitTime());
			ptmt.setString(7, resumeInformation.getWork1CompanyName());
			ptmt.setString(8, resumeInformation.getWork1Postion());
			ptmt.setString(9, resumeInformation.getWork1Responsibility());

			// ִ��
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
//			// 3.�������ݿ⣬ʵ����ɾ�Ĳ�
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT Resume_ID, Name FROM Resume_label");
//			// ��������ݣ�rs.next()����true
//			while (rs.next()) {
//				System.out.println(rs.getInt("Resume_ID") + " ��ע��" + rs.getString("Name"));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

}
