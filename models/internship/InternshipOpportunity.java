package models.internship;

import models.user.CompanyRepresentative;

public class InternshipOpportunity {
    private String internshipTitle;
    private String description;
    private String internshipLevel;
    private String preferredMajors;
    private String applicationOpeningDate;
    private String applicationClosingDate;
    private String companyName;
    private CompanyRepresentative[] companyRepresentatives;
    private int numberOfSlots;

    private String status = "PENDING";

    public InternshipOpportunity(
            String internshipTitle,
            String description,
            String internshipLevel,
            String preferredMajors,
            String applicationOpeningDate,
            String applicationClosingDate,
            String companyName,
            int numberOfSlots
    ) {
		if (internshipTitle == null
				|| description == null
				|| internshipLevel == null
				|| preferredMajors == null
				|| applicationOpeningDate == null
				|| applicationClosingDate == null
				|| companyName == null
				|| numberOfSlots == null
		) {
			throw new IllegalArgumentException("Fields cannot be null");
		} else if (numberOfSlots < 1 || 10 < numberOfSlots) {
			throw new IllegalArgumentException("Number of slots must be between 1 and 10 inclusive");
		}

        this.internshipTitle = internshipTitle;
        this.description = description;
        this.internshipLevel = internshipLevel;
        this.preferredMajors = preferredMajors;
        this.applicationOpeningDate = applicationOpeningDate;
        this.applicationClosingDate = applicationClosingDate;
        this.companyName = companyName;
        this.numberOfSlots = numberOfSlots;
    }

    public String getInternshipTitle() {
        return internshipTitle;
    }

    public void setInternshipTitle(String internshipTitle) {
        this.internshipTitle = internshipTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInternshipLevel() {
        return internshipLevel;
    }

    public void setInternshipLevel(String internshipLevel) {
        this.internshipLevel = internshipLevel;

    }

    public String getPreferredMajors() {
        return preferredMajors;
    }

    public void setPreferredMajors(String preferredMajors) {
        this.preferredMajors = preferredMajors;
    }

    public String getApplicationOpeningDate() {
        return applicationOpeningDate;
    }

    public void setApplicationOpeningDate(String applicationOpeningDate) {
        this.applicationOpeningDate = applicationOpeningDate;
    }

    public String getApplicationClosingDate() {
        return applicationClosingDate;
    }

    public void setApplicationClosingDate(String applicationClosingDate) {
        this.applicationClosingDate = applicationClosingDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public CompanyRepresentative[] getCompanyRepresentatives() {
        return companyRepresentatives;
    }

    public void setCompanyRepresentatives(CompanyRepresentative[] companyRepresentatives) {
        this.companyRepresentatives = companyRepresentatives;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
