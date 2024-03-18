package memberManagement.model.service;

import java.sql.SQLException;
import java.util.Map;

public interface MMService {

	/** 전체 회원 조회
	 * @return map
	 * @throws SQLException
	 */
	Map<String, Object> selectAll() throws SQLException;

	/** 회원 추가
	 * @param memberNo
	 * @param memberName
	 * @param gradeName
	 * @return result
	 * @throws SQLException
	 */
	int addMember(String memberNo, String memberName, String gradeName) throws SQLException;

	
	/** 회원 삭제
	 * @param memberNo
	 * @return result
	 * @throws SQLException
	 */
	int MMdelete(String memberNo) throws SQLException;

}
