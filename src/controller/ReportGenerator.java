package controller;

public class ReportGenerator {
    private InternshipController internshipController;
    private ApplicationController applicationController;

    public ReportGenerator(InternshipController internshipController, ApplicationController applicationController) {
        this.internshipController = internshipController;
        this.applicationController = applicationController;
    }
}