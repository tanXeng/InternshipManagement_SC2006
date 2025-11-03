package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.user.*;
import model.internship.*;
import controller.*;
import cli.*;

public class MainApp {
	private static UserController userController;
    private static ApplicationController appController;
    private static AuthManager authManager;
    private static InternshipController internshipController;
    private static ReportGenerator reportGenerator;
	private static CLI cli;
	public static void main(String[] args) {
		init();
		cli.start();
	}

	private static void init() {
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<CareerCenterStaff> careerCenterStaffs = new ArrayList<CareerCenterStaff>();
        ArrayList<CompanyRepresentative> companyRepresentatives = new ArrayList<CompanyRepresentative>();
        ArrayList<InternshipApplication> internshipApplications = new ArrayList<InternshipApplication>();
        ArrayList<RepresentativeApplication> representativeApplications = new ArrayList<RepresentativeApplication>();
        ArrayList<InternshipOpportunity> internshipOpportunities = new ArrayList<InternshipOpportunity>();

        File studentsFile = new File("data/sample_student_list.csv");
        try {
            Scanner studentScanner = new Scanner(studentsFile);
            studentScanner.nextLine(); // skip header row

            while (studentScanner.hasNextLine()) {
                String[] line = studentScanner.nextLine().split(",");

                // parse the last 7 digits of the StudentID 
                String studentIDString = line[0].substring(1, line[0].length() - 1); 
                int userID = Integer.parseInt(studentIDString); 
                String name = line[1];
                String major = line[2];
                int yearOfStudy = Integer.parseInt(line[3]);
                String passwordHash = "password"; // Default password hash
                List<InternshipApplication> emptyApplications = new ArrayList<>();
                Student student = new Student(
                    userID, 
                    name, 
                    passwordHash, 
                    yearOfStudy, 
                    major, 
                    emptyApplications // Passing the empty List
                );
                students.add(student);
            } 
			studentScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // load the other users here
        // ...

        // load the pending applications here
        // ...

        // load created internship opportunities here
        // ...
        
        // initialize the controllers
        userController = new UserController(students, companyRepresentatives, careerCenterStaffs);
        authManager = new AuthManager(userController);
        internshipController = new InternshipController(internshipOpportunities);
        appController = new ApplicationController(internshipApplications, representativeApplications, internshipController, userController);
        reportGenerator = new ReportGenerator(internshipController, appController);
		cli = new CLI(userController, authManager);
	}
}