package memberManagement.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import memberManagement.model.dto.MM;
import memberManagement.model.service.MMService;
import memberManagement.model.service.MMServiceImpl;

@WebServlet("/MM/search")
public class MMSearchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			MMService service = new MMServiceImpl();
			String searchType = req.getParameter("searchType");
			String keyword = req.getParameter("keyword");
			
			List<MM> searchList = service.search(searchType, keyword);
			
			req.setAttribute("searchList", searchList);
			
			// main.jsp로 포워드
			String path = "/WEB-INF/views/main.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	

}
