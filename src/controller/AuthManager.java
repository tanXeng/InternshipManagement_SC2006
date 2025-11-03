package controller;
import model.*;
import java.util.List;
import java.util.Objects;

public class AuthManager {
    private UserController userController;
    private User currentUser;

    public AuthManager(UserController userController) {
        this.userController = userController;
        this.currentUser = null; // Initialize currentUser to null as no one is logged in initially
    }

    public static String hash(String s) {
        // hashing implement later
        return s;
    }

    public User login(String name, String password) {
        // hash password here (unhashed for now cuz lazy)
        String passwordHash = hash(password);

        List<User> allUsers = userController.getAllUsers();
        for (User user : allUsers) {
            if (Objects.equals(name, user.getName()) && Objects.equals(passwordHash, user.getPasswordHash())) {
                this.currentUser = user; 
                return user;
            }
        }
        // return null if no match is found
        return null;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public void changePassword(String newPassword) {
        currentUser.setPasswordHash(newPassword);
    }

    public void logout() {
        // save all user array lists to a file
        userController.saveAllUsers();

        // clear session
        this.currentUser = null;
    }
}