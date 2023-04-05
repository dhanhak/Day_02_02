package insertmessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dto.DTO;

@WebServlet("/InsertMessage")
public class InsertMessage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//		abc.append("작성자 : " + writer + "\t" + "메세지 : " + message);


		//		response.sendRedirect("success.html");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String writer = request.getParameter("writer");
		String message = request.getParameter("message");
		System.out.println("작성자 : " + writer + " " + "메세지 : " + message);


		DAO dao = DAO.getInstance();
		try {
			int result = dao.Insert(new DTO(0, writer, message));
			if(result == 1) {
				System.out.println("인서트 성공");
			} else {
				System.out.println("인서트 실패");
			}
			response.sendRedirect("SelectMessage");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		}

//		PrintWriter abc = response.getWriter();
//		abc.append("<form action='index.html' method='post'>");
//		abc.append("<button id='toIndex'>toIndex</button");
//		abc.append("</form>");
	}

}
