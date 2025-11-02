package models.user;

public class Student extends User {
	private String major;
	private int yearOfStudy;

	public Student(String name, String passwordHash, String major, int yearOfStudy) {
		super(name, passwordHash);

		this.yearOfStudy = yearOfStudy;
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
}
