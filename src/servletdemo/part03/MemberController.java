package servletdemo.part03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginPro")
public class MemberController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post : 한글 깨짐 문제 해결 방법. 아래와 같이 작성하면 된다.
		req.setCharacterEncoding("UTF-8");
		
		String fid = req.getParameter("fid");
		String fpass = req.getParameter("fpass");

		MemberDTO dto = new MemberDTO();
		dto.setFid(fid);
		dto.setFpass(fpass);
		
		req.setAttribute("dto", dto); // request영역에 저장됨
		
		String path = "/servletview/part03/result.jsp";
		RequestDispatcher dis = req.getRequestDispatcher(path);
		dis.forward(req, resp);

	} // end doPost()

} // end class
