package controller;

import java.util.ArrayList;

import model.user.*;
import model.internship.*;

public class Database {
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<CompanyRepresentative> representatives = new ArrayList<CompanyRepresentative>();
	private ArrayList<CareerCenterStaff> staffs = new ArrayList<CareerCenterStaff>();

	public Database() {}

	public void createStudent(Student student) {
		students.add(student);
	}

	public void createCompanyRepresentative(CompanyRepresentative rep) {
		representatives.add(rep);
	}

	public void createCareerCenterStaff(CareerCenterStaff staff) {
		staffs.add(staff);
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public ArrayList<CompanyRepresentative> getCompanyRepresentatives() {
		return representatives;
	}

	public ArrayList<CareerCenterStaff> getCareerCenterStaffs() {
		return staffs;
	}

	// TODO make CRUD for all models
}
