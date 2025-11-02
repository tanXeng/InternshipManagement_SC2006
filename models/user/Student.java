package models.user;

import java.util.ArrayList;

public class Student extends User {
	private String major;
	private int yearOfStudy;
	private ArrayList<InternshipApplication> internshipApplications = new ArrayList<InternshipApplication>;

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

	public ArrayList<InternshipApplication> getInternshipApplications() {
		return internshipApplications;
	}

	public void addInternshipApplication(InternshipApplication internshipApplication) {
		if (internshipApplications.size() == 3) {
			System.out.println("You have reach the maximum of 3 internship applications");
		} else {
			internshipApplications.add(internshipApplication);
		}
	}

	public void removeInternshipApplications(InternshipApplication internshipApplication) {
		internshipApplications.remove(internshipApplication);
	}
}
