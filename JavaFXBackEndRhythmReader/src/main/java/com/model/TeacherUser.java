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
       this.teachingClasses = teachingClasses;
       this.gradebook = gradebook;
    }

    public boolean addStudent(StudentUser student) {
        if (teachingClasses == null || teachingClasses.isEmpty()) {
            System.out.println("Teacher has no classes assigned.");
            return false;
        }
        boolean studentAdded = false;

        for (String classCode: teachingClasses) {
            if (!student.getClasses().contains(classCode)) {
                student.getClasses().add(classCode);


                Map<String, String> studentRecord = new HashMap<>();
                studentRecord.put("First Name", student.getFirstName());
                studentRecord.put("Last Name", student.getLastName());
                studentRecord.put("Grade", String.valueOf(student.getGrade()));
                studentRecord.put("Progress", String.valueOf(student.getProgress()));

                ArrayList<Map<String, String>> records = gradebook.get(classCode);
                if (records == null) {
                    records = new ArrayList<>();
                }
                records.add(studentRecord);
                gradebook.put(classCode, records);

                studentAdded = true;
            }
        }
        if (!studentAdded) {
            System.out.println("Student " + student.getLastName() +" " + student.getLastName() + 
            " is already enrolled in class.");
            return false;
        }
         return true;
    }

    public ArrayList<String> getTeachingClasses() {
        return teachingClasses;
    }
    public boolean setTeachingClasses(ArrayList<String> teachingClass) {
        if (teachingClasses == null ) return false;
        this.teachingClasses = teachingClass;
        return true;  
    }

    public Map<String, ArrayList<Map<String, String>>> getGradebook() {
        return gradebook;
    }
    public boolean setGradebook(Map<String, ArrayList<Map<String, String>>> gradebook){
        if (gradebook == null ) return false;
        this.gradebook = gradebook;
        return true;  
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


    public boolean assignFlashcard(Flashcard flashcard, String assignedClass) {
        // Finish method

        return true;
    }

     /**
     * Determines that current User is a Teacher
     * @return boolean answer True that User is a Teacher
     */
    public boolean isTeacher() {
        return true;
    }
    
}