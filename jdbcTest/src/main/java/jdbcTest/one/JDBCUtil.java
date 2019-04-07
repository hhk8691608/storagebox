package jdbcTest.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import jdbcTest.one.mobel.ResumeInformation;
import jdbcTest.one.mobel.ResumeLabel;

public class JDBCUtil {
// jdbc:mysql://120.25.193.143:3306/app
	public static final String URL = "jdbc:mysql://120.25.193.143:3306/app?user=jiaozhen&password=jiaozhen16&useUnicode=true&characterEncoding=UTF8";
	public static final String USER = "jiaozhen";
	public static final String PASSWORD = "jiaozhen16";
	private static Connection conn = null;

	static {
		try {
			// 1.加载驱动程序  
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			com.mysql.cj.jdbc.Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			// 2. 获得数据库连接
//			conn = DriverManager.getConnection(URL, USER, PASSWORD);
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
	
	/**
	 * 关闭数据库链接
	 * @return
	 */
	public static void close() {
		if(conn != null) {
			try {
				conn.close();  //关闭数据库链接
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
public static void addResumeLabel(ResumeLabel resumeLabel) {
		
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO Resume_label(resume_id, Name, Edu1_fraud, Work1_time_fraud, Work2_time_fraud, Work3_time_fraud,"
					+ "Work1_position_fraud, Work2_position_fraud, Work3_position_fraud)" + "values("
					+ "?,?,?,?,?,?,?,?,?)";
			
			
			// 预编译
			PreparedStatement ptmt = conn.prepareStatement(sql); // 预编译SQL，减少sql执行
			// 传参
			ptmt.setInt(1, Integer.parseInt(""+ resumeLabel.getResumeId() ));
			ptmt.setString(2, resumeLabel.getName());
			ptmt.setString(3, resumeLabel.getEdu1Fraud());
			ptmt.setString(4, resumeLabel.getWork1TimeFraud());
			ptmt.setString(5, resumeLabel.getWork2TimeFraud());
			ptmt.setString(6, resumeLabel.getWork3TimeFraud());
			ptmt.setString(7, resumeLabel.getWork1PositionFraud());
			ptmt.setString(8, resumeLabel.getWork2PositionFraud());
			ptmt.setString(9, resumeLabel.getWork3PositionFraud());

			// 执行
			ptmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static void addResumeInformation(ResumeInformation resumeInformation) {
		
		try {
			Connection conn = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO resume_information(resume_id, name, edu1_enter_time, edu1_graduate_time, work1_enter_time, work1_exit_time,"
					+ "work1_company_name, work1_position, work1_responsibility)" + "values("
					+ "?,?,?,?,?,?,?,?,?)";
			
			// 预编译
			PreparedStatement ptmt = conn.prepareStatement(sql); // 预编译SQL，减少sql执行
			// 传参
			ptmt.setInt(1, Integer.parseInt(""+ resumeInformation.getResumeId() ));
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
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		

		
	}
	
	
	public void getModelInfo() throws SQLException {
		// 2. 获得数据库连接
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				// 3.操作数据库，实现增删改查
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT Resume_ID, Name FROM Resume_label");
				// 如果有数据，rs.next()返回true
				while (rs.next()) {
					System.out.println(rs.getInt("Resume_ID") + " 备注：" + rs.getString("Name"));
				}
	}
	

	public static void main(String[] args) throws Exception {
		
		
		
		
		Long resumeId = 8L;
		String name = "ACE";
		String edu1Fraud = "1";
		String work1TimeFraud = "11";
		String work1PositionFraud = "111";
		String work2TimeFraud = "22";
		String work2PositionFraud = "222";
		String work3TimeFraud = "333";
		String work3PositionFraud = "333";

		
		ResumeLabel resumeLabel = new ResumeLabel();
		resumeLabel.setResumeId(resumeId);
		resumeLabel.setEdu1Fraud(edu1Fraud);
		resumeLabel.setWork1TimeFraud(work1TimeFraud);
		resumeLabel.setWork1PositionFraud(work1PositionFraud);
		resumeLabel.setWork2TimeFraud(work2TimeFraud);
		resumeLabel.setWork2PositionFraud(work2PositionFraud);
		resumeLabel.setWork3TimeFraud(work3TimeFraud);
		resumeLabel.setWork3PositionFraud(work3PositionFraud);
		
		
		String edu1EnterTime = "2011";
		String edu1GraduateTime = "2015";
		String work1EnterTime = "2022年1月";
		String work1ExitTime = "2028年2月";
		String work1CompanyName = "阿里云";;
		String work1Postion = "java底层架构开发";;
		String work1Responsibility = "看信心看月亮看看";

		
		ResumeInformation resumeInformation = new ResumeInformation();
		resumeInformation.setResumeId(resumeId);
		resumeInformation.setEdu1EnterTime(edu1EnterTime);
		resumeInformation.setEdu1GraduateTime(edu1GraduateTime);
		resumeInformation.setWork1EnterTime(work1EnterTime);
		resumeInformation.setWork1ExitTime(work1ExitTime);
		resumeInformation.setWork1CompanyName(work1CompanyName);
		resumeInformation.setWork1Postion(work1Postion);
		resumeInformation.setWork1Responsibility(work1Responsibility);
		
		try {
			addResumeInformation(resumeInformation);
			addResumeLabel(resumeLabel);
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
	}
	
	private static void Test_addResumeLabel() {
		Long resumeId = 8L;
		String name = "ACE";
		String edu1Fraud = "1";
		String work1TimeFraud = "11";
		String work1PositionFraud = "111";
		String work2TimeFraud = "22";
		String work2PositionFraud = "222";
		String work3TimeFraud = "333";
		String work3PositionFraud = "333";

		
		ResumeLabel resumeLabel = new ResumeLabel();
		resumeLabel.setResumeId(resumeId);
		resumeLabel.setEdu1Fraud(edu1Fraud);
		resumeLabel.setWork1TimeFraud(work1TimeFraud);
		resumeLabel.setWork1PositionFraud(work1PositionFraud);
		resumeLabel.setWork2TimeFraud(work2TimeFraud);
		resumeLabel.setWork2PositionFraud(work2PositionFraud);
		resumeLabel.setWork3TimeFraud(work3TimeFraud);
		resumeLabel.setWork3PositionFraud(work3PositionFraud);
		
		try {
			
			addResumeLabel(resumeLabel);
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}

	private static void Test_addResumeInformation() {
		Long resumeId = 12L;
		String edu1EnterTime = "2011";
		String edu1GraduateTime = "2015";
		String work1EnterTime = "2022年1月";
		String work1ExitTime = "2028年2月";
		String work1CompanyName = "阿里云";;
		String work1Postion = "java底层架构开发";;
		String work1Responsibility = "看信心看月亮看看";

		
		ResumeInformation resumeInformation = new ResumeInformation();
		resumeInformation.setResumeId(resumeId);
		resumeInformation.setEdu1EnterTime(edu1EnterTime);
		resumeInformation.setEdu1GraduateTime(edu1GraduateTime);
		resumeInformation.setWork1EnterTime(work1EnterTime);
		resumeInformation.setWork1ExitTime(work1ExitTime);
		resumeInformation.setWork1CompanyName(work1CompanyName);
		resumeInformation.setWork1Postion(work1Postion);
		resumeInformation.setWork1Responsibility(work1Responsibility);
		
		try {
			
			addResumeInformation(resumeInformation);
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
				
	}

}
