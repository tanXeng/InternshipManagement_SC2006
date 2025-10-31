package java.model.internship;
import java.model.*;
import java.model.user.*;

public class InternshipApplication extends Application {
    private InternshipOpportunity internshipOpportunity;
    private boolean placementConfirmed; // after company approves, the student has to accept. So we use placementConfirmed
    private boolean withdrawalRequested;
    private boolean withdrawalApproved;

    public InternshipApplication(String applicationID, Student applicant, InternshipOpportunity internshipOpportunity) {
        super(applicationID, applicant);
        this.internshipOpportunity = internshipOpportunity;
        this.placementConfirmed = false;
        this.withdrawalRequested = false;
        this.withdrawalApproved = false;
    }

    public InternshipOpportunity getInternshipOpportunity() {
        return internshipOpportunity;
    }

    public void setInternshipOpportunity(InternshipOpportunity internshipOpportunity) {
        this.internshipOpportunity = internshipOpportunity;
    }

    public boolean getPlacementConfirmed() {
        return this.placementConfirmed;
    }
    
    public void setPlacementConfirmed(boolean placementConfirmed) {
        this.placementConfirmed = placementConfirmed;
    }

    public boolean getWithdrawalRequested() {
        return this.withdrawalRequested;
    }

    public void setWithdrawalRequested(boolean withdrawalRequested) {
        this.withdrawalRequested = withdrawalRequested;
    }

    public boolean getWithdrawalApproved() {
        return this.withdrawalApproved;
    }

    public void setWithdrawalApproved(boolean withdrawalApproved) {
        this.withdrawalApproved = withdrawalApproved;
    }
}
