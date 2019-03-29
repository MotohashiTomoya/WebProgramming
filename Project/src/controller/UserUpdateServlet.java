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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		ログインセッションがない場合、ログイン画面にリダイレクトする
		HttpSession session = request.getSession();
		User us=(User) session.getAttribute("userInfo");

		if(us==null) {
			response.sendRedirect("LoginServlet");
			return;
		}
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");

		UserDao dao = new UserDao();

		if (!password.equals(password1) || name.isEmpty() || birthDate.isEmpty()) {

			User u = new User();
			// IDセット（エラー時共通）
			u.setId(Integer.parseInt(id));
			// ログインIDセット（エラー時共通）
			u.setLoginId(loginId);

			// 名前が空でない場合、名前セット
			if (!name.isEmpty()) {
				u.setName(name);
			}
			// 生年月日が空でない場合、生年月日セット
			if (!birthDate.isEmpty()) {
				u.setBirthDateStr(birthDate);
			}
			// 元画面の表示用情報を格納
			request.setAttribute("user", u);
			// エラーメッセージセット
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			// 元画面に画面遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);
			return;

		} if (password.isEmpty() || password1.isEmpty()) {
			dao.InsertInformation2(id, name, birthDate);
			response.sendRedirect("UserListServlet");
		}else {
			// success
			// 登録処理
			dao.InsertInformation1(id, password, name, birthDate);

			// 一覧画面に遷移（doGet実行）
			response.sendRedirect("UserListServlet");
		}



	}

}
