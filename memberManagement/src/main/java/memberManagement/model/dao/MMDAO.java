package memberManagement.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import memberManagement.model.dto.MM;

public interface MMDAO {

	/** 회원 전체 조회 
	 * @param conn
	 * @return memberList
	 * @throws SQLException
	 */
	List<MM> selectAll(Connection conn) throws SQLException;

	/** 회원 추가
	 * @param conn 
	 * @param memberNo
	 * @param memberName
	 * @param gradeName
	 * @return result
	 * @throws SQLException
	 */
	int addMember(Connection conn, String memberNo, String memberName, String gradeName) throws SQLException;

	int deleteMember(Connection conn, String memberNo) throws SQLException;

}