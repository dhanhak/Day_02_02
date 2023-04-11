package insertmessage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dto.DTO;

@WebServlet("*.message")
public class MessageController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getRequestURI();
		System.out.println(cmd);

		try {
			if(cmd.equals("/select.message")) {

				DAO dao = DAO.getInstance();
				List<DTO> list = dao.Selectlist();
				request.setAttribute("list", list);
				request.getRequestDispatcher("list.jsp").forward(request, response);

			}else if(cmd.equals("/insert.message")) {
				
				String writer = request.getParameter("writer");
				String message = request.getParameter("message");
				DAO dao = DAO.getInstance();
				int result = dao.Insert(new DTO(0, writer, message));
				response.sendRedirect("/index.html");
				
			}else if(cmd.equals("/delete.message")) {
				
				DAO dao = DAO.getInstance();
				int del = Integer.parseInt(request.getParameter("delID"));
				int result = dao.Delete(new DTO(del,null,null));
				response.sendRedirect("/select.message");
				
			}else if(cmd.equals("/update.message")) {
				
				DAO dao = DAO.getInstance();
				int updId = Integer.parseInt(request.getParameter("updId"));
				String updMsg = request.getParameter("updMsg");
				String updWriter = request.getParameter("updWriter");
				
				int result = dao.Update(new DTO(updId,updMsg,updWriter));
				response.sendRedirect("/select.message");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
