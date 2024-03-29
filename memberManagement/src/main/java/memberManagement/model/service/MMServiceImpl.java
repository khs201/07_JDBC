package memberManagement.model.service;

import static memberManagement.common.JDBCTemplate.close;
import static memberManagement.common.JDBCTemplate.commit;
import static memberManagement.common.JDBCTemplate.getConnection;
import static memberManagement.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import memberManagement.model.dao.MMDAO;
import memberManagement.model.dao.MMDAOImpl;
import memberManagement.model.dto.MM;

public class MMServiceImpl implements MMService{
	
	private MMDAO dao = null;
	
	public MMServiceImpl() {
		dao = new MMDAOImpl();
	}

	@Override
	public Map<String, Object> selectAll(String asc, String desc) throws SQLException {
		
		Connection conn = getConnection();
		
		
		List<MM> memberList = null;
		
		if(asc == null && desc == null)	memberList = dao.selectAll(conn);
		else if(asc != null)						memberList = dao.selectAllAsc(conn, asc);
		else														memberList = dao.selectAllDesc(conn, desc); 
		
		close(conn);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("memberList", memberList);
		
		return map;
	}

	@Override
	public int addMember(String memberNo, String memberName, String gradeName) throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.addMember(conn, memberNo, memberName, gradeName);
		
		// 트랜젝션 제어 처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn); // 커넥션 반환
		
		
		return result;
	}
	@Override
	public int MMdelete(String memberNo) throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.deleteMember(conn, memberNo);
		
		// 트랜젝션 제어 처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn); // 커넥션 반환
		
		return result;
	}
	
	@Override
	public int MMUpdate(String memberNo, String updatedMemberName, String updatedGradeName) throws SQLException {
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, memberNo, updatedMemberName, updatedGradeName);
		
		// 트랜젝션 제어 처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn); // 커넥션 반환
		
		return result;
	}
	
	@Override
	public List<MM> search(String searchType, String keyword) throws SQLException {
		
		Connection conn = getConnection();
		
		List<MM> searchList = dao.search(conn, searchType, keyword);
//		String memNo = " WHERE MEMBER_NO = ";
//		String memNa = " WHERE MEMBE"
		
//		if(searchType == "MEMBER_NO")	searchList = dao.search(conn, );
//		else if(searchType == "MEMBER_NAME")						searchList = dao.search(conn, );
//		else														searchList = dao.search(conn, ); 
		
//		if(searchType.equals())
		
		
		
		
		
		return searchList;
	}
	
	
}
