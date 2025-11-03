package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import models.user.*;
import models.internship.*;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<InternshipApplication> internshipApplications = new ArrayList<InternshipApplication>();
	private static ArrayList<InternshipOpportunity> internshipOpportunities = new ArrayList<InternshipOpportunity>();

	private static void init() {
		File studentsFile = new File("data/sample_student_list.csv");
		try {
			Scanner studentScanner = new Scanner(studentsFile);
			studentScanner.nextLine();
			while (studentScanner.hasNextLine()) {
				String[] line = studentScanner.nextLine().split(",");
				Student student = new Student(line[1], "password", line[2], Integer.parseInt(line[3]));
				users.add(student);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}

		File careerCenterStaffFile = new File("data/sample_staff_list.csv");
		try {
			Scanner careerCenterStaffScanner = new Scanner(careerCenterStaffFile);
			careerCenterStaffScanner.nextLine();
			while (careerCenterStaffScanner.hasNextLine()) {
				String[] line = careerCenterStaffScanner.nextLine().split(",");
				CareerCenterStaff staff = new CareerCenterStaff(line[1], "password");
				users.add(staff);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static User login(String name, String passwordHash) {
		for (User user: users) {
			if (Objects.equals(name, user.getName()) && Objects.equals(passwordHash, user.getPasswordHash())) {
				return user;
			}
		}

		return null;
	}

	private static String inputString(String text) {
		System.out.println(text);
		String s = scanner.nextLine();
		if (s.isEmpty()) {
			System.exit(0);
		}
		
		return s;
	}

	private static int inputInt(String text) {
		System.out.println(text);
		int n = scanner.nextInt();
		scanner.nextLine();
		if (n == 0) {
			System.exit(0);
		}
		
		return n;
	}

	public static void main(String[] args) {
		init();

		User user = null;

		boolean loop = true;
		int choice;
		String name, passwordHash;
		System.out.println("To exit the program at any time, press ENTER");
		do {
			if (user == null) {
				System.out.println("=".repeat(20));
				System.out.println("1) Login");
				System.out.println("2) Create a new account");
				choice = inputInt("Select an option: ");

				switch (choice) {
					case 1:
						System.out.println("=".repeat(20));
						name = inputString("Enter your name: ") ;
						passwordHash = inputString("Enter your password: ");

						user = login(name, passwordHash);

						if (user == null) {
							System.out.println("Invalid credentials");
						}

						break;
					case 2:
						System.out.println("=".repeat(20));
						System.out.println("Are you a:");
						System.out.println("1) Student");
						System.out.println("2) Company Representative");
						System.out.println("3) Career Center Staff");
						choice = inputInt("Enter a choice: ");

						switch (choice) {
							case 1:
								System.out.println("=".repeat(20));
								name = inputString("Enter your name: ");
								passwordHash = inputString("Enter your password: ");
								String major = inputString("Enter your major: ");
								int yearOfStudy = inputInt("Enter your year: ");
								Student s = new Student(name, passwordHash, major, yearOfStudy);
								users.add(s);
								user = s;
								break;
							case 2:
								System.out.println("Not implemented");
								loop = false;
								break;
							case 3:
								System.out.println("Not implemented");
								loop = false;
								break;
						}

						break;
					default:
						break;
				}
			} else if (user instanceof Student) {
				System.out.println("=".repeat(20));
				System.out.println("1) Apply for internship");
				choice = inputInt("Enter an option: ");

				switch (choice) {
					case 1:
						break;
					default:
						break;
				}
			} else if (user instanceof CompanyRepresentative) {
				CompanyRepresentative rep = (CompanyRepresentative)user;
				switch (rep.getStatus()) {
					case "APPROVED":
						System.out.println("Not implemented");
						break;
					case "PENDING":
						System.out.println("Your application is pending");
						break;
					case "REJECTED":
						System.out.println("Your application has been rejected");
						break;
				}
			} else if (user instanceof CareerCenterStaff) {
				System.out.println("=".repeat(20));
				System.out.println("1) Approve/reject company representatives");
				System.out.println("2) Approve/reject internship opportunities");
				System.out.println("3) Approve/reject student withdrawal requests");
				System.out.println("4) Generate internship report");
				choice = inputInt("Enter an option: ");

				switch (choice) {
					case 1:
						System.out.println("Not implemented");
						break;
					case 2:
						System.out.println("Not implemented");
						break;
					case 3:
						System.out.println("Not implemented");
						break;
					case 4:
						System.out.println("Not implemented");
						break;
					default:
						break;
				}
			} else {
				System.out.println("Not implemented");
				loop = false;
			}
		} while (loop);
	}
}
