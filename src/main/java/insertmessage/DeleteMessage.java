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

@WebServlet("/DeleteMessage")
public class DeleteMessage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = DAO.getInstance();
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter printWriter = response.getWriter();
		
		int del = Integer.parseInt(request.getParameter("del"));
		try {
			int result = dao.Delete(new DTO(del,null,null));
			if(result == 1) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			response.sendRedirect("SelectMessage");
//			printWriter.append("<form action='SelectMessage' method='get'>");
//			printWriter.append("<button>리스트</button>");
//			printWriter.append("</from>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


