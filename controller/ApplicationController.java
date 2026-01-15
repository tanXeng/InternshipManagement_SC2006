package controller;

import model.internship.*;
import model.user.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationController {
    private ArrayList<InternshipApplication> internshipApplications;
    private InternshipController internshipController;
    private UserController userController;

    public ApplicationController(
        ArrayList<InternshipApplication> internshipApplications,
        ArrayList<RepresentativeApplication> representativeApplications,
        InternshipController internshipController,
        UserController userController
    ) {
        this.internshipApplications = new ArrayList<>(internshipApplications);
        this.RepresentativeApplications = new ArrayList<>(representativeApplications);
        this.internshipController = internshipController;
        this.userController = userController;
    }

    // process application function should work for both types of applications
    // the cli to use will depend on which user is logged in
}
