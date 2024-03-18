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

@WebServlet("/MM/update")
public class MMUpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String memberNo = req.getParameter("memberNo");
			String updatedMemberName = req.getParameter("updatedMemberName");
			String updatedGradeName = req.getParameter("updatedGradeName");
			
			MMService service = new MMServiceImpl();
			
			int result = service.MMUpdate(memberNo, updatedMemberName, updatedGradeName);
			
			String message = null;
			HttpSession session = req.getSession();
			if(result > 0) { // 수정 성공
			message = "수정 되었습니다";
			}
			else { // 수정 실패
				message = "수정 실패 했습니다";
			}
			
			session.setAttribute("message", message);
			resp.sendRedirect("/");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
		
	}
	


