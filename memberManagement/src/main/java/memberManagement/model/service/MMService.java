package memberManagement.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import memberManagement.model.dto.MM;

public interface MMService {

	/** 전체 회원 조회
	 * @param desc 
	 * @param asc 
	 * @return map
	 * @throws SQLException
	 */
	Map<String, Object> selectAll(String asc, String desc) throws SQLException;

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

	/** 회원 정보 수정
	 * @param memberNo
	 * @param updatedGradeName 
	 * @param updatedMemberName 
	 * @return
	 * @throws SQLException
	 */
	int MMUpdate(String memberNo, String updatedMemberName, String updatedGradeName) throws SQLException;

	List<MM> search(String searchType, String keyword) throws SQLException;

}
