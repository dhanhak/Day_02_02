package insertmessage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dto.DTO;

@WebServlet("/UpdateMessage")
public class UpdateMessage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = DAO.getInstance();
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int updId = Integer.parseInt(request.getParameter("updId"));
		String updMsg = request.getParameter("updMsg");
		String updWriter = request.getParameter("updWriter");
		
		try {
			int result = dao.Update(new DTO(updId,updMsg,updWriter));
			if(result==1) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			
			response.sendRedirect("SelectMessage");
//			PrintWriter printWriter = response.getWriter();
//			printWriter.append("<form action='SelectMessage' method='get'>");
//			printWriter.append("<button>리스트</button>");
//			printWriter.append("</from>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
