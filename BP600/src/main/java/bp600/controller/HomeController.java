package bp600.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.do")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		String uri=request.getRequestURI();  /*http://localhost:8080/BP600/home.do를 /BP600/home.do으로*/
		String contextPath = request.getContextPath();
		String command = uri.substring(contextPath.length());
		
		String viewPage = "/WEB-INF/views/main/home.jsp";
		String contentPage="/WEB-INF/views/contents/home_main.jsp";
		switch(command) {
		
		case "/home.do":
			contentPage="/WEB-INF/views/contents/home_main.jsp";
			break;
		case "/menu1.do":
			contentPage="/WEB-INF/views/contents/main_sub1.jsp";
			break;
		case "/menu2.do":
			contentPage="/WEB-INF/views/contents/main_sub2.jsp";
			break;	
		default:
			contentPage="/WEB-INF/views/errors/404.jsp";
			break;
		}
		request.setAttribute("contentPage", contentPage);
		
		request.getRequestDispatcher(viewPage).forward(request, response);
		/*request.getRequestDispatcher(String path) path(경로)에 해당하는 자원을 처리할 RequestDispatcher 객체를 리턴*/
		/*그리고 forward*/
	}

}
