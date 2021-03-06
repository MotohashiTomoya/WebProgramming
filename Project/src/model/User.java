package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable {
	private int id;
	private String loginId;
	private String name;
	private Date birthDate;
	private String password;
	private String createDate;
	private String updateDate;

	// ログインセッションを保存するためのコンストラクタ
	public User(String loginId, String name) {
		this.loginId = loginId;
		this.name = name;
	}

	// 全てのデータをセットするコンストラクタ
	public User(int id, String loginId, String name, String password, Date birthDate, String createDate,
			String updateDate) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.password = password;
		this.birthDate = birthDate;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthDateStr() {
		String str = "";
		if (this.birthDate != null) {
			str = new SimpleDateFormat("yyyy-MM-dd").format(this.birthDate);
		}
		return str;
	}

	public void setBirthDateStr(String birthDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date formatDate = null;
		try {
			formatDate = sdf.parse(birthDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.birthDate = formatDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}
