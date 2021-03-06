package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.Code;
import model.User;

public class UserDao {

	/**
	 * ログインIDとパスワードに紐づくユーザ情報を返す
	 * @param loginId
	 * @param password
	 * @return
	 */
	public User findByLoginInfo(String loginId, String password) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, Code.code(password));
			ResultSet rs = pStmt.executeQuery();

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}

			// 必要なデータのみインスタンスのフィールドに追加
			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			return new User(loginIdData, nameData);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	/**
	 * 全てのユーザ情報を取得する
	 * @return
	 */
	public List<User> findAll() {
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "SELECT * FROM user WHERE login_id!='admin'";

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, password, birthDate, createDate, updateDate);

				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	public void InsertInformation(String loginId, String password, String name, String birthDate) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="INSERT INTO user(login_id,name,birth_date,password,create_date,update_date)VALUES(?,?,?,?,NOW(),NOW())";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,loginId );
			ps.setString(2,name);
			ps.setString(3,birthDate );
			ps.setString(4,Code.code(password));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally  {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


	}

	public User findByLoginInfo1(String id ) {
		Connection conn = null;

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setLoginId(rs.getString("login_id"));
				u.setName(rs.getString("name"));
				u.setBirthDate(rs.getDate("birth_date"));
				u.setCreateDate(rs.getString("create_date"));
				u.setUpdateDate(rs.getString("update_date"));


				return u;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;


	}

	public void InsertInformation1(String Id,  String password, String name,String birthDate ) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="UPDATE user SET password=?,name=?,birth_date=?,update_date=NOW() WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,Code.code(password));
			ps.setString(2,name);
			ps.setString(3,birthDate );
			ps.setString(4,Id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally  {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


	}
	public void InsertInformation2(String Id, String name,String birthDate ) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="UPDATE user SET name=?,birth_date=?,update_date=NOW() WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1,name);
			ps.setString(2,birthDate );
			ps.setString(3,Id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally  {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void InsertInformation2(String Id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="DELETE FROM user WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,Id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally  {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


	}
		public int findBynewuserinfo(String loginId) {
			Connection conn = null;
			try {
				conn = DBManager.getConnection();
//				サブリクエ
				String sql = "SELECT count(*)AS matchUser FROM user WHERE login_id=?";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, loginId);
				ResultSet rs = pStmt.executeQuery();
				rs.next();
				return rs.getInt("matchUser");
			}catch (SQLException e) {
				e.printStackTrace();
			} finally  {
				// データベース切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return 0;

		}

		public List<User> findSearch(String loginIdP, String userNameP ,String staBirthDate,String endBirthDate ) {
			Connection conn = null;
			List<User> userList = new ArrayList<User>();

			try {
				// データベースへ接続
				conn = DBManager.getConnection();

				// SELECT文を準備
				// TODO: 未実装：管理者以外を取得するようSQLを変更する
				String sql = "SELECT * FROM user WHERE login_id!='admin'";


				if(!loginIdP.equals("")) {
					sql += " AND login_id = '" + loginIdP + "'";
				}
				if(!userNameP.equals("")) {
					sql += " AND name LIKE  '%" + userNameP + "%'";
				}
				if(!staBirthDate.equals("")) {
					sql += " AND birth_date >= '" + staBirthDate + "'";
				}
				if(!endBirthDate.equals("")) {
					sql += " AND birth_date <='" + endBirthDate + "'";
				}

				System.out.println(sql);

				// SELECTを実行し、結果表を取得
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				// 結果表に格納されたレコードの内容を
				// Userインスタンスに設定し、ArrayListインスタンスに追加
				while (rs.next()) {
					int id = rs.getInt("id");
					String loginId = rs.getString("login_id");
					String name = rs.getString("name");
					Date birthDate = rs.getDate("birth_date");
					String password = rs.getString("password");
					String createDate = rs.getString("create_date");
					String updateDate = rs.getString("update_date");
					User user = new User(id, loginId, name, password, birthDate, createDate, updateDate);

					userList.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				// データベース切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
			}
			return userList;
		}
}









