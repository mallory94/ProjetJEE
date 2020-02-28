package data;

public class User {

	public User(String login, String passwd) {

		this.login = login;
		this.passwd = passwd;
	}
	private String login;
	private String passwd;
	@Override
	public String toString() {
		return "User [login=" + login + ", passwd=" + passwd + "]";
	}

}
