package cli;
import java.util.Scanner;

import controller.AuthManager;
import model.user.Student;

public class StudentMenu {
    private Scanner sc = new Scanner(System.in);
    private AuthManager authManager;
   
    public StudentMenu(AuthManager authManager) {
        this.authManager = authManager;
    }

    public void runMenu(Student student) {
        int choice;
        System.out.println();
        System.out.println("=".repeat(20));
        System.out.println();
        System.out.println("1) Apply for internship");
        // add more options later
        System.out.println("2) Change Password");
        System.out.println("3) Logout");
        choice = inputInt("Enter an option: ");
        switch (choice) {
            case 1:
                System.out.println("Not implemented");
                break;
            case 2:
                String newPassword = inputString("Enter new password: ");
                authManager.changePassword(newPassword);
                break;
            case 3:
                System.out.println("Logging out...");
                authManager.logout();
                break;
            default:
                break;
		}
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
