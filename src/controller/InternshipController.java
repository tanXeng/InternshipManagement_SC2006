package controller;
import model.internship.*;
import java.util.ArrayList;
import java.util.List;

public class InternshipController {
    private List<InternshipOpportunity> internshipOpportunities;

    public InternshipController(ArrayList<InternshipOpportunity> internshipOpportunities) {
        this.internshipOpportunities = new ArrayList<>(internshipOpportunities);
    }
}