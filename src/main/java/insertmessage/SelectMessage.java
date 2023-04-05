package insertmessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dto.DTO;

@WebServlet("/SelectMessage")
public class SelectMessage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = DAO.getInstance();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		try {
			List<DTO> list = dao.Selectlist();
			System.out.println("ID\tWRITER\tMESSAGE");
			for(DTO dto : list) {
				System.out.println(dto.getId()+"\t"+dto.getWriter()+"\t"+dto.getMessage());
//				printWriter.append(dto.toString());
			}
			
//			printWriter.append("<a href = 'index.html'>back</a>");
//			printWriter.append("<br>");
//			
//			printWriter.append("<form action='DeleteMessage' method='post'>");
//			printWriter.append("<input type='text' name = 'del' placeholder = '삭제할 아이디'>");
//			printWriter.append("<button>삭제</button>");
//			printWriter.append("</form>");
//			
//			printWriter.append("<form action='UpdateMessage' method='post'>");
//			printWriter.append("<input type='text' name ='updId' placeholder = '수정할 아이디'>");
//			printWriter.append("<input type='text' name ='updMsg' placeholder = '수정할 메세지'>");
//			printWriter.append("<input type='text' name ='updWriter' placeholder = '수정할 이름'>");
//			printWriter.append("<button>수정</button>");
//			printWriter.append("</form>");

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
