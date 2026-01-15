package cli;

import java.util.Scanner;

import model.User;
import model.user.Student;

public class StudentMenu {
    private static Scanner sc = new Scanner(System.in);
   
    public static User runMenu(Student student) {
        int choice;
        System.out.println();
        System.out.println("=".repeat(20));
        System.out.println();
        // add more options later
        System.out.println("1) Apply for internship");
        System.out.println("2) Change Password");
        System.out.println("3) Logout");
        choice = inputInt("Enter an option: ");
        switch (choice) {
            case 1:
                System.out.println("Not implemented");
				return student;
            case 2:
                String newPassword = inputString("Enter new password: ");
                // authManager.changePassword(newPassword);
				return student;
            case 3:
                System.out.println("Logging out...");
				return null;
            default:
				return student;
		}
    }

    private static String inputString(String text) {
        System.out.println(text);
        String s = sc.nextLine();
        if (s.isEmpty()) {
            System.exit(0);
        }
        return s;
    }

    private static int inputInt(String text) {
        System.out.println(text);
        int n = sc.nextInt();
        sc.nextLine();
        if (n == 0) {
            System.exit(0);
        }
        
        return n;
	}
}
