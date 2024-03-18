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

@WebServlet("/MM/add")
public class MMAddServlet extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	try {
		
		MMService service = new MMServiceImpl();
		
		// 파라미터 얻어오기
		String memberNo = req.getParameter("memberNo");
		String memberName = req.getParameter("memberName");
		String gradeName = req.getParameter("gradeName");
		
		int result = service.addMember(memberNo, memberName, gradeName);
		
		String message = null;
		
		if(result>0) message = "추가 성공!";
		else message = "추가 실패;";
		
		HttpSession session = req.getSession();
		session.setAttribute("message", message);
		
		resp.sendRedirect("/");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
}
	

}
