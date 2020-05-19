package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SelectSQL;
import dto.Person;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		SelectSQL select = new SelectSQL();
		//↓get型もpost型もgetParameterでとる 文字列(string)をint型に変換するためにInteger.parseInt(変換したい文字列※基本的に数字)
		Person person = select.select(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("person", person);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/show.jsp");
		dispatcher.forward(request, response); // フォワードを行う
	}
}
