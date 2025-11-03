package model;
import java.time.LocalDate;

public abstract class Application {

    protected String applicationID;
    protected User applicant;
    protected Status status;
    protected LocalDate dateApplied;

    public Application(String applicationID, User applicant) {
        if (applicationID == null || applicationID.trim().isEmpty()) {
            throw new IllegalArgumentException("Application ID cannot be null or empty.");
        }
        if (applicant == null) {
            throw new IllegalArgumentException("Applicant cannot be null.");
        }
        
        this.applicationID = applicationID;
        this.applicant = applicant;
        this.dateApplied = LocalDate.now(); 
        this.status = Status.PENDING; 
    }


    public String getApplicationID() {
        return this.applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public User getApplicant() {
        return this.applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public Status getStatus() {
        return this.status;
    }

    protected void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDateApplied() {
        return this.dateApplied;
    }
}

