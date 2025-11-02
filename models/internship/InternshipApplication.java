package models.internship;

import models.user.Student;

public class InternshipApplication {
    private Student student;
    private InternshipOpportunity internship;
    private String status = "PENDING";

    public InternshipApplication(Student student, InternshipOpportunity internship) {
        this.student = student;
        this.internship = internship;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public InternshipOpportunity getInternship() {
        return internship;
    }

    public void setInternship(InternshipOpportunity internship) {
        this.internship = internship;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

