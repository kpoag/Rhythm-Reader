package com.model;

import java.util.ArrayList;
import java.util.List;

public class TeacherUser extends User {

    private ArrayList<StudentUser> assignedClass;
    private ArrayList<Double> gradebook;

    public TeacherUser(String userName, String firstName, String lastName, int age, String phoneNumber) {
       super(userName, firstName, lastName, age, phoneNumber);
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

    public boolean assignFlashcard(Flashcard deck, String assignedClass) {
        return true;
    }
    
}
