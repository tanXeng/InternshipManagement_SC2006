package cli;

import java.util.Scanner;

import controller.AuthManager;
import model.user.CompanyRepresentative;

public class RepMenu {
    private Scanner sc = new Scanner(System.in);
    private AuthManager authManager;

    public RepMenu(AuthManager authManager) {
        this.authManager = authManager;
    }

    public void runMenu(CompanyRepresentative rep) {
        int choice;
        System.out.println();
        System.out.println("=".repeat(20));
        System.out.println();
        System.out.println("1) Logout");
        choice = inputInt("Enter an option: ");
        switch (choice) {
            case 1:
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
