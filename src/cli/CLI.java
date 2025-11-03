package cli;
import java.util.ArrayList;
import java.util.Scanner;
import controller.*;
import model.*;
import model.internship.InternshipApplication;
import model.user.CareerCenterStaff;
import model.user.CompanyRepresentative;
import model.user.Student;
import java.util.List;

public class CLI {
    private Scanner sc = new Scanner(System.in);
    private RepMenu repMenu;
    private StaffMenu staffMenu;
    private StudentMenu studentMenu;
    private UserController userController;
    private AuthManager authManager;

    public CLI(UserController userController, AuthManager authManager) {
        this.userController = userController;
        this.authManager = authManager;
        this.studentMenu = new StudentMenu(authManager);
        this.staffMenu = new StaffMenu(authManager);
        this.repMenu = new RepMenu(authManager);
    }

    public void start() {
        int choice;
        int userID;
        String userIDString;
        String name;
        String password;
        User user = null;
        List<InternshipApplication> emptyApplications = new ArrayList<>();
        System.out.println();
        System.out.println("=".repeat(20));
        System.out.println();
        System.out.println("1) Login");
        System.out.println("2) Create a new account");
        choice = inputInt("Select an option: ");

        boolean loop = true;
        System.out.println("To exit or logout of the program at any time, press ENTER");
        do {
            user = authManager.getCurrentUser();
            if (user == null) {
                switch (choice) {
                    // login
                    case 1:
                        System.out.println();
                        System.out.println("=".repeat(20));
                        System.out.println();
                        name = inputString("Enter your name: ");
                        password = inputString("Enter your password: ");

                        user = authManager.login(name, password);

                        if (user == null) {
                            System.out.println("Account not found!");
                        }
                        break;

                    // create new account
                    case 2:
                        System.out.println();
                        System.out.println("=".repeat(20));
                        System.out.println();
                        System.out.println("Are you a:");
                        System.out.println("1) Student");
                        System.out.println("2) Company Representative");
                        System.out.println("3) Career Center Staff");
                        choice = inputInt("Enter a choice: ");

                        switch (choice) {
                            case 1:
                                System.out.println();
                                System.out.println("=".repeat(20));
                                System.out.println();
                                userIDString = inputString("Enter your student ID: ");
                                userID = Integer.parseInt(userIDString.substring(1, userIDString.length() - 1));
                                name = inputString("Enter your name: ");
                                password = inputString("Enter your password: ");
                                String major = inputString("Enter your major: ");
                                int yearOfStudy = inputInt("Enter your year: ");
                                Student s = new Student(userID, name, AuthManager.hash(password), yearOfStudy, major, emptyApplications);
                                userController.createStudentAccount(s);
                                break;
                            case 2:
                                System.out.println("Not implemented");
                                break;
                            case 3:
                                System.out.println("Not implemented");
                                break;
                        }
                        break;

                    default:
                        break;
                }
            } else if (user instanceof Student) {
                // render Student Menu
                Student student = (Student)user;
                studentMenu.runMenu(student);

            } else if (user instanceof CompanyRepresentative) {
                CompanyRepresentative rep = (CompanyRepresentative)user;
                switch (rep.getStatus()) {
                    case Status.APPROVED:
                        // render the CompanyRepresentative menu if his application was accepted
                        repMenu.runMenu(rep);
                        break;
                    case Status.PENDING:
                        System.out.println("Your application is pending");
                        break;
                    case Status.REJECTED:
                        System.out.println("Your application has been rejected");
                        break;
                    case Status.FILLED:
                        System.out.println("Your application has been filled");
                        break;
                }

            } else if (user instanceof CareerCenterStaff) {
                // render CareerCenterStaff Menu
                CareerCenterStaff staff = (CareerCenterStaff)user;
                staffMenu.runMenu(staff);

            } else {
                System.out.println("Not implemented");
                loop = false;
            }

        } while (loop);
    }


    private String inputString(String text) {
		System.out.println(text);
		String s = sc.nextLine();
		if (s.isEmpty()) {
			System.exit(0);
		}
		return s;
	}
    private int inputInt(String text) {
        System.out.println(text);
        int n = sc.nextInt();
        sc.nextLine();
        if (n == 0) {
            System.exit(0);
        }
        
        return n;
	}
}
