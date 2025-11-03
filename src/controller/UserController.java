package controller;
import model.*;
import model.user.*;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<Student> students;
    private List<CompanyRepresentative> companyRepresentatives;
    private List<CareerCenterStaff> careerCenterStaffs;

    public UserController(List<Student> students, List<CompanyRepresentative> CompanyRepresentatives, List<CareerCenterStaff> CareerCenterStaffs) {
        this.students = new ArrayList<>(students);
        this.companyRepresentatives = new ArrayList<>(CompanyRepresentatives); 
        this.careerCenterStaffs = new ArrayList<>(CareerCenterStaffs);  
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        
        allUsers.addAll(this.students);
        allUsers.addAll(this.companyRepresentatives);
        allUsers.addAll(this.careerCenterStaffs);
        return allUsers; // Return the combined list
    }

    public void createStudentAccount(Student student) {
        // technically we should check if the account already exists
        this.students.add(student);
    }

    public void createCompanyRepAccount(CompanyRepresentative rep) {
        // technically we should check if the account already exists
        this.companyRepresentatives.add(rep);
    }

    public void createCareerCenterStaffAccount(CareerCenterStaff staff) {
        // technically we should check if the account already exists
        this.careerCenterStaffs.add(staff);
    }

    public void saveAllUsers() {
        // save all user information to a csv file
    }

}