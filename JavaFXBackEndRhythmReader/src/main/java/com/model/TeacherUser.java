package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TeacherUser extends User {

    private ArrayList<String> teachingClasses;
    private Map<String, ArrayList<Map<String, String>>> gradebook;

    public TeacherUser(String userName, String firstName, String lastName, String email,
    String password, int points, ArrayList<String> badges, ArrayList<String> friends, 
    ArrayList<String> teachingClasses, Map<String, ArrayList<Map<String, String>>> gradebook ) {
       super(userName, firstName, lastName, email, password, points, badges, friends);
       this.teachingClasses = new ArrayList<>();
       this.gradebook = new HashMap<>();
    }

    public boolean addStudent(StudentUser student) {
        // Finish method
        return true;
    }

    public ArrayList<String> getTeachingClasses() {
        return teachingClasses;
    }
    public void setTeachingClasses(ArrayList<String> teachingClass) {
        this.teachingClasses = teachingClass;
    }

    public Map<String, ArrayList<Map<String, String>>> getGradebook() {
        return gradebook;
    }
    public void setGradebook(Map<String, ArrayList<Map<String, String>>> gradebook){
        this.gradebook = gradebook;
    }

    public double viewStudentsProgress(){
        // finish method
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


    public boolean assignFlashcard(Flashcard deck, String assignedClass) {
        // finish method
        return true;
    }
    
}