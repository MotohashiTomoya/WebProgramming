package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		// URLからGETパラメータとしてIDを受け取る
				String id = request.getParameter("id");

				// 確認用：idをコンソールに出力
				System.out.println(id);


				// TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
				UserDao dao = new UserDao();
				User user = dao.findByLoginInfo1(id);



				// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード

				request.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
				dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String birthDate=request.getParameter("birthDate");

		UserDao dao = new UserDao();
		dao.InsertInformation1(id, password, name, birthDate);

		HttpSession session = request.getSession();
		 session.setAttribute("user", dao);


		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListServlet");

	}

}
