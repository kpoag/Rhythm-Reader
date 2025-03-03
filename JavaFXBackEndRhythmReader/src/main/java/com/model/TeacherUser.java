package com.model;

import java.util.ArrayList;
import java.util.List;

public class TeacherUser extends User {

    private List<StudentUser> assignedClass;
    private List<Double> gradebook;

    public TeacherUser(String firstName, String lastName, String username, String email, String password,
                        List<StudentUser> assignedClass, List<Double> gradebook) {
        super(firstName, lastName, username, email, password);
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

    public List<StudentUser> getAssignedClass(){
        return assignedClass;
    }

    public boolean assignFlashcard(Flashcard deck, String assignedClass) {
        return true;
    }
    
}
