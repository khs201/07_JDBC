package memberManagement.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import memberManagement.model.service.MMService;
import memberManagement.model.service.MMServiceImpl;

// 멤버 수정창 이동
@WebServlet("/MM/delete")
public class MMDeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String memberNo = req.getParameter("memberNo");
			
			MMService service = new MMServiceImpl();
			
			int result = service.MMdelete(memberNo);
			
			String message = null;
			HttpSession session = req.getSession();
			if(result > 0) { // 삭제 성공
			message = "삭제 되었습니다";
			}
			else {
				message = "삭제 실패 했습니다";
			}
			
			session.setAttribute("message", message);
			resp.sendRedirect("/");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
