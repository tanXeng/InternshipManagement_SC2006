package java.main;
import java.model.User;

public class MainApp {
    public static void main(String[] args) {
        // initialization and data loading
        initializeSystem(); 

        // main app loop
        while (true) {
            User activeUser = null;
            
            // login
            activeUser = handleLogin(); 
            
            if (activeUser == null) {
                break;
            }

            // menu
            handleMenu(activeUser); 
            
            // logout and save Data
            saveData(); 
        }

        System.out.println("Application shutting down.");
    }
    
    private static void initializeSystem() {
        // load user data
    }
    private static User handleLogin() { /* ... */ }
    private static void handleMenu(User user) { /* ... */ }
    private static void saveData() { /* ... */ }
}
