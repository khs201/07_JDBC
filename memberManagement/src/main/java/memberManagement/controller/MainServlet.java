package memberManagement.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import memberManagement.model.dto.MM;
import memberManagement.model.service.MMService;
import memberManagement.model.service.MMServiceImpl;

@WebServlet("")
public class MainServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		

			try {
				MMService service = new MMServiceImpl(); // 서비스 객체 생성
				
				// 할 일 목록 + 완료된 할 일 개수 조회하는
				// 서비스 호출 후 결과 반환 받기
				
				String asc = req.getParameter("asc");
				String desc = req.getParameter("desc");
				
				Map<String, Object> map = service.selectAll(asc, desc);
				
				// map에 담긴 데이터 분리 (형변환)
				List<MM> memberList = (List<MM>)map.get("memberList");
				
				// 분리된 데이터를 request 객체에 속성으로 추가
				req.setAttribute("memberList", memberList);
				
				// main.jsp로 포워드
				String path = "/WEB-INF/views/main.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		
		
	}
	

}
