package models.user;

public abstract class User {
	private static int nextID = 1;

	private int userID;
	private String name;
	private String passwordHash;

	public User(String name, String passwordHash) {
		userID = nextID;
		nextID++;
		this.name = name;
		this.passwordHash = passwordHash;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
}
