package edu.kh.dept.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.dept.model.dto.Department;

public interface DepartmentDAO {

	/** 부서 전체 조회
	 * @param conn
	 * @return deptList
	 * @throws SQLException
	 */
	List<Department> selectAll(Connection conn) throws SQLException;

	/** 부서 추가
	 * @param conn
	 * @param dept
	 * @return
	 */
	int insertDepartment(Connection conn, Department dept) throws SQLException;

	int deleteDepartment(Connection conn, Department dept) throws SQLException;

	Department selectOne(Connection conn, String deptId) throws SQLException;

	int deleteDepartment(Connection conn, String deptId) throws SQLException;

	/**
	 * @param conn
	 * @param dept
	 * @return
	 * @throws SQLException
	 */
	int updateDepartment(Connection conn, Department dept) throws SQLException;

	/**
	 * @param conn
	 * @param keyword
	 * @return deptList (조회결과 없으면 비어있음)
	 * @throws SQLException
	 */
	List<Department> search(Connection conn, String keyword) throws SQLException;


	
	


	
	
	
}
