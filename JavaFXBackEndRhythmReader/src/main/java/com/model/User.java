package com.model;

import java.util.UUID;

public class User {
	private UUID id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
    private int points;
    private String classroom;
    private Module assignedModules;
    private Module completedModules;
    private Module currentModule;
    private Module recommendedModules;
    private String deadlines;
    private String grades;
    private String badges;
    private String progress;
    private DifficultyLevel skillLevel;
    private String teachingClasses;
    private UserList friends;
    
	
    /**
     * 
     * @param userName
     * @param firstName
     * @param lastName
     * @param age
     * @param phoneNumber
    */

	public User(String userName, String firstName, String lastName, String email,
    String password, int points, String classroom, Module assignedModules, Module completedModules,
    Module currentModule, Module recommendedModules, String deadlines, String grades, String badges,
    String progress, DifficultyLevel skillLevel, UserList friends, String teachingClasses) {
		this.id = UUID.randomUUID();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
        this.email= email;
        this.password= password;
        this.points= points;
        this.classroom= classroom;
        this.assignedModules= assignedModules;
        this.completedModules= completedModules;
        this.currentModule= currentModule;
        this.recommendedModules= recommendedModules;
        this.deadlines= deadlines;
        this.grades= grades;
        this.badges= badges;
        this.progress= progress;
        this.skillLevel= skillLevel;
        this.friends= friends;
        this.teachingClasses= teachingClasses;
	}
	public User(UUID id, String userName, String firstName, String lastName, String email,
    String password, int points, String classroom, Module assignedModules, Module completedModules,
    Module currentModule, Module recommendedModules, String deadlines, String grades, String badges,
    String progress, DifficultyLevel skillLevel, UserList friends, String teachingClasses) {
		this.id = UUID.randomUUID();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
        this.email= email;
        this.password= password;
        this.points= points;
        this.classroom= classroom;
        this.assignedModules= assignedModules;
        this.completedModules= completedModules;
        this.currentModule= currentModule;
        this.recommendedModules= recommendedModules;
        this.deadlines= deadlines;
        this.grades= grades;
        this.badges= badges;
        this.progress= progress;
        this.skillLevel= skillLevel;
        this.friends= friends;
        this.teachingClasses= teachingClasses;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}

    public void setUserName(String userName)
    {
        this.userName= userName;
    }
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
    public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
    public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
    public String getClassroom() {
		return classroom;
	}
	
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
    public Module getAssignedModules() {
		return assignedModules;
	}
	
	public void setAssignedModules(Module assignedModules) {
		this.assignedModules = assignedModules;
	}
    public Module getCompleteddModules() {
		return completedModules;
	}
	
	public void setCompletedModules(Module completedModules) {
		this.completedModules = completedModules;
	}
    public Module getCurrentModule() {
		return currentModule;
	}
	
	public void setCurrentModule(Module currentModule) {
		this.currentModule = currentModule;
	}
    public Module getRecommendedModules() {
		return recommendedModules;
	}
	
	public void setRecommendedModules(Module recommendedModules) {
		this.recommendedModules = recommendedModules;
	}
    public String getDeadlines() {
		return deadlines;
	}
	
	public void setDeadlines(String deadlines) {
		this.deadlines = deadlines;
	}
    public String getGrades() {
		return grades;
	}
	
	public void setGrades(String grades) {
		this.grades = grades;
	}
    public String getBadges() {
		return badges;
	}
	
	public void setBadges(String badges) {
		this.badges = badges;
	}
    public String getProgress() {
		return progress;
	}
	
	public void setProgress(String progress) {
		this.progress = progress;
	}
    public DifficultyLevel getskillLevel() {
		return skillLevel;
	}
	
	public void setSkillLevel(DifficultyLevel skillLevel) {
		this.skillLevel = skillLevel;
	}
    public String getTeachingClasses() {
		return teachingClasses;
	}
	
	public void setTeachingClasses(String teachingClasses) {
		this.teachingClasses = teachingClasses;
	}
    public UserList getFriends() {
		return friends;
	}
	
	public void setFriends(UserList friends) {
		this.friends = friends;
	}

	public String toString() {
		return userName;
	}
	
}