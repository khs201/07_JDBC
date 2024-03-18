package memberManagement.model.dao;

import static memberManagement.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import memberManagement.model.dto.MM;

public class MMDAOImpl implements MMDAO{
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	// 기본 생성자로 객체 생성 시
	// Properties 객체 생성 + xml 파일 내용 읽어오기 
	public MMDAOImpl() {
		
		try {
		prop = new Properties();
		String path = MMDAOImpl.class.getResource("/memberManagement/sql/sql.xml").getPath();
			
		prop.loadFromXML(new FileInputStream(path));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public List<MM> selectAll(Connection conn) throws SQLException {
		List<MM> memberList = new ArrayList<MM>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // 조회 결과 한 행씩 접근
				String memberNo = rs.getString("MEMBER_NO");
				String memberName = rs.getString("MEMBER_NAME");
				String gradeName = rs.getString("GRADE_NAME");
				
				MM mm = new MM(memberNo, memberName, gradeName);
				memberList.add(mm);
				
			}
			
			
		} finally {
			close(stmt);
			close(rs);
		}
		
		
		return memberList;
	}
	
	@Override
	public int addMember(Connection conn, String memberNo, String memberName, String gradeName) throws SQLException {
		int result = 0;
		
		try {
			String sql = prop.getProperty("addMM");
			pstmt = conn.prepareStatement(sql);
			
			//(MEMBER_NO, MEMBER_NAME, GRADE_NAME)
			pstmt.setString(1, memberNo);
			pstmt.setString(2, memberName);
			pstmt.setString(3, gradeName);
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	@Override
	public int deleteMember(Connection conn, String memberNo) throws SQLException {
		
		int result = 0;
		try {
			String sql = prop.getProperty("deleteMM");

			sql = String.format(sql + " '%s' ", memberNo);
			
			stmt = conn.createStatement();
			
			//(MEMBER_NO, MEMBER_NAME, GRADE_NAME)
			result = stmt.executeUpdate(sql);
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	@Override
	public int updateMember(Connection conn, String memberNo, String updatedMemberName, String updatedGradeName)
			throws SQLException {
		int result = 0;
		try {

			String sql = String.format(
					"UPDATE MEMBER SET MEMBER_NAME = '%s', GRADE_NAME = '%s' WHERE MEMBER_NO = '%s'"
					, updatedMemberName, updatedGradeName, memberNo
					);
			
			stmt = conn.createStatement();
			
			//(MEMBER_NO, MEMBER_NAME, GRADE_NAME)
			result = stmt.executeUpdate(sql);
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
