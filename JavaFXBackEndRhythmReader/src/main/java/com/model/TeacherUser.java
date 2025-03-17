package com.model;

import java.util.ArrayList;
import java.util.List;

public class TeacherUser extends User {

    private ArrayList<StudentUser> assignedClass;
    private ArrayList<Double> gradebook;

    public TeacherUser(String userName, String firstName, String lastName, String email,
    String password, int points, ArrayList<String> badges, ArrayList<String> friends) {
       super(userName, firstName, lastName, email, password, points, badges, friends);
       this.assignedClass = new ArrayList<>();
       this.gradebook = new ArrayList<>();
    }

    public boolean addStudent(StudentUser student) {
        return true;
    }

    public double viewStudentsProgress(){
        return 0.0;
    }

    public String sendFeedback(String feedback, String userName){
        return "Good Job";
    }

    public String createClassroom(String className){
        return "XYZ";
    }

    public boolean removeStudent(StudentUser student) {
        return false;
    }

    public ArrayList<StudentUser> getAssignedClass(){
        return assignedClass;
    }

    public ArrayList<Double> getGradebook() {
        return gradebook;
    }

    public boolean assignFlashcard(Flashcard deck, String assignedClass) {
        return true;
    }
    
}