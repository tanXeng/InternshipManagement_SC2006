package cli;

import java.util.Scanner;

import model.User;
import model.user.CareerCenterStaff;

public class StaffMenu {
    private static Scanner sc = new Scanner(System.in);

    public static User runMenu(CareerCenterStaff staff) {
        int choice;
        System.out.println();
        System.out.println("=".repeat(20));
        System.out.println();
        System.out.println("1) Approve/reject company representatives");
        System.out.println("2) Approve/reject internship opportunities");
        System.out.println("3) Approve/reject student withdrawal requests");
        System.out.println("4) Generate internship report");
        System.out.println("5) Logout");
        choice = inputInt("Enter an option: ");

        switch (choice) {
            case 1:
                System.out.println("Not implemented");
				return staff;
            case 2:
                System.out.println("Not implemented");
				return staff;
            case 3:
                System.out.println("Not implemented");
				return staff;
            case 4:
                System.out.println("Not implemented");
				return staff;
            case 5:
                System.out.println("Logging out...");
				return null;
            default:
				return staff;
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
