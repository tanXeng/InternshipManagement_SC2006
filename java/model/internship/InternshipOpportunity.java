package java.model.internship;
import java.model.*;
import java.model.user.CompanyRepresentative;
import java.time.LocalDate;
import java.util.Arrays;

public class InternshipOpportunity {
    private String internshipTitle;
    private String description;
    private InternshipLevel internshipLevel;
    private String preferredMajors;
    private LocalDate applicationOpeningDate;
    private LocalDate applicationClosingDate;
    private InternshipOpportunityStatus status;
    private String companyName;
    private CompanyRepresentative[] companyRepresentatives;
    private int representativeCount;
    private int numberOfSlots;
    public static final int MAX_NUM_SLOTS = 10;

    public InternshipOpportunity(String internshipTitle, String description, InternshipLevel internshipLevel, 
                                 String preferredMajors, LocalDate applicationOpeningDate, LocalDate applicationClosingDate, 
                                 String companyName, CompanyRepresentative[] companyRepresentatives, int numberOfSlots) {
        
        // input validation
        if (applicationOpeningDate == null || applicationClosingDate == null || applicationClosingDate.isBefore(applicationOpeningDate)) {
            // throw an exception if dates are null or closing date is before opening date
            throw new IllegalArgumentException("Invalid date range: Opening and closing dates must be provided, and closing date must be on or after opening date.");
        }
        if (numberOfSlots <= 0 || numberOfSlots > MAX_NUM_SLOTS) {
            throw new IllegalArgumentException("Number of slots must be between 1 and " + MAX_NUM_SLOTS + ".");
        }

        this.internshipTitle = internshipTitle;
        this.description = description;
        this.internshipLevel = internshipLevel;
        this.preferredMajors = preferredMajors;
        this.applicationOpeningDate = applicationOpeningDate;
        this.applicationClosingDate = applicationClosingDate;
        this.companyName = companyName;
        this.numberOfSlots = numberOfSlots;
        this.companyRepresentatives = companyRepresentatives;
        this.representativeCount = 0;

        // count the representatives 
        for (CompanyRepresentative rep : this.companyRepresentatives) {
            if (rep != null) {
                this.representativeCount++;
            }
        }
        
        // when first created, the status should be PENDING 
        this.status = InternshipOpportunityStatus.PENDING; 
    }
    
    public String getInternshipTitle() {
        return this.internshipTitle;
    }

    public void setInternshipTitle(String internshipTitle) {
        this.internshipTitle = internshipTitle;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InternshipLevel getInternshipLevel() {
        return this.internshipLevel;
    }

    public void setInternshipLevel(InternshipLevel internshipLevel) {
        this.internshipLevel = internshipLevel;
    }

    public String getPreferredMajors() {
        return this.preferredMajors;
    }

    public void setPreferredMajors(String preferredMajors) {
        this.preferredMajors = preferredMajors;
    }

    public LocalDate getApplicationOpeningDate() {
        return this.applicationOpeningDate;
    }

    public void setApplicationOpeningDate(LocalDate applicationOpeningDate) {
        this.applicationOpeningDate = applicationOpeningDate;
    }

    public LocalDate getApplicationClosingDate() {
        return this.applicationClosingDate;
    }

    public void setApplicationClosingDate(LocalDate applicationClosingDate) {
        this.applicationClosingDate = applicationClosingDate;
    }

    public InternshipOpportunityStatus getStatus() {
        return this.status;
    }
    
    public void setStatus(InternshipOpportunityStatus status) {
        this.status = status;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public CompanyRepresentative[] getCompanyRepresentatives() {
        
        // return a copy of the active representatives (up to representativeCount)
        return Arrays.copyOf(this.companyRepresentatives, this.representativeCount);
    }

    public int addCompanyRepresentative(CompanyRepresentative repToAdd) {
    if (repToAdd == null) {
        // FAILURE!!!
        return 1;
    }

    // check for duplicates 
    for (int i = 0; i < this.representativeCount; i++) {
        // requires CompanyRepresentative to have a valid equals() method
        if (this.companyRepresentatives[i].equals(repToAdd)) {

            // FAILURE!!!
            return 1; 
        }
    }

    // check if resizing is necessary
    if (this.representativeCount == this.companyRepresentatives.length) {
        // resize the array: create a new array 50% larger
        int newSize = this.companyRepresentatives.length == 0 ? 1 : this.companyRepresentatives.length + (this.companyRepresentatives.length / 2);
        this.companyRepresentatives = Arrays.copyOf(this.companyRepresentatives, newSize);
    }
    this.companyRepresentatives[this.representativeCount] = repToAdd;
    this.representativeCount++;
    
    // success
    return 0;
    }

    public int deleteCompanyRepresentative(CompanyRepresentative repToDelete) {
        if (repToDelete == null || this.representativeCount == 0) {
            // FAILURE!!!
            return 1;
        }

        int indexToDelete = -1;

        // find the index of the representative to delete
        for (int i = 0; i < this.representativeCount; i++) {
            if (this.companyRepresentatives[i].equals(repToDelete)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            // FAILURE!!!
            return 1; // representative not found
        }

        // shift all subsequent elements one position to the left
        for (int i = indexToDelete; i < this.representativeCount - 1; i++) {
            this.companyRepresentatives[i] = this.companyRepresentatives[i + 1];
        }

        // clear the last occupied slot and update the count
        this.companyRepresentatives[this.representativeCount - 1] = null;
        this.representativeCount--;

        // success
        return 0;
    }
    
    public int getNumberOfSlots() {
        return this.numberOfSlots;
    }

    public int setNumberOfSlots(int numberOfSlots) {
    if (numberOfSlots <= 0 || numberOfSlots > MAX_NUM_SLOTS) {

        // FAILURE!!!
        return 1; // Number of slots must be between 1 and 10.
    }
    this.numberOfSlots = numberOfSlots;
    
    // success
    return 0;
    }
}
