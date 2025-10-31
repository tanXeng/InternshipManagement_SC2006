package java.model;

public class Student extends User {
    private int YearOfStudy;
    private String Major;
    private InternshipApplication[] internshipApplications;
    private int applicationCount;
    public static final int MAX_APPLICATIONS = 3;

    public Student(int userID, String name, String passwordHash, int YearOfStudy, String Major, InternshipApplication[] internshipApplications) {
        super(userID, name, passwordHash);
        this.YearOfStudy = YearOfStudy;
        this.Major = Major;
        this.internshipApplications = internshipApplications;

        // count the non-null elements
        this.applicationCount = 0;
        for (InternshipApplication app : internshipApplications) {
            if (app != null) {
                this.applicationCount++;
        }
    }
    }

    public int getYearOfStudy() {
        return YearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        YearOfStudy = yearOfStudy;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public InternshipApplication[] getInternshipApplications() {
        return internshipApplications;
    }

    public int addInternshipApplications(InternshipApplication internshipApplication) {
        if (this.applicationCount < MAX_APPLICATIONS) {
            this.internshipApplications[this.applicationCount] = internshipApplication;
            this.applicationCount++; 

            // success
            return 0; 

        } else {

            // FAILURE!!!
            return 1; 
        }
    }

    public int deleteInternshipApplication(InternshipApplication applicationToDelete) {
    if (applicationToDelete == null || this.applicationCount == 0) {

        //FAILURE!!!
        return 1; 
    }

    int indexToDelete = -1;

    // find the index of the application to delete
    for (int i = 0; i < this.applicationCount; i++) {
        if (this.internshipApplications[i].equals(applicationToDelete)) {
            indexToDelete = i;
            break;
        }
    }

    if (indexToDelete == -1) {

        // FAILURE!!!
        return 1; 
    }

    // shift all subsequent elements one position to the left
    for (int i = indexToDelete; i < this.applicationCount - 1; i++) {
        this.internshipApplications[i] = this.internshipApplications[i + 1];
    }

    // clear the last occupied slot and update the count
    this.internshipApplications[this.applicationCount - 1] = null;
    this.applicationCount--;

    // success 
    return 0; 
    }
}

