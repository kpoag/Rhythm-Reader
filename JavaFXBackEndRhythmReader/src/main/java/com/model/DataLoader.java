package com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
	
	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				String userName = (String)personJSON.get(USER_USER_NAME);
				String firstName = (String)personJSON.get(USER_FIRST_NAME);
				String lastName = (String)personJSON.get(USER_LAST_NAME);
				String email = (String)personJSON.get(USER_EMAIL);
				String password = (String)personJSON.get(USER_PASSWORD);
				int points= ((Long)personJSON.get(USER_POINTS)).intValue();
				String classroom = (String)personJSON.get(USER_CLASSROOM);
				Module assignedModules = (Module)personJSON.get(USER_ASSIGNED_MODULES);
				Module completedModules = (Module)personJSON.get(USER_COMPLETED_MODULES);
				Module currentModule = (Module)personJSON.get(USER_CURRENT_MODULE);
				Module recommendedModules = (Module)personJSON.get(USER_RECOMMENDED_MODULES);
				String deadlines = (String)personJSON.get(USER_DEADLINES);
				String grades = (String)personJSON.get(USER_GRADES);
				String badges = (String)personJSON.get(USER_BADGES);
				String progress = (String)personJSON.get(USER_PROGRESS);
				DifficultyLevel skillLevel = (DifficultyLevel)personJSON.get(USER_SKILL_LEVEL);
				String teachingClasses = (String)personJSON.get(USER_TEACHING_CLASSES);
				UserList friends = (UserList)personJSON.get(USER_FRIENDS);


				
				
				users.add(new User(id, userName, firstName, lastName, email, password, points,
				classroom, assignedModules, completedModules, currentModule, recommendedModules, deadlines,
				grades, badges, progress, skillLevel, friends));
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}

	public static void main(String[] args){
		ArrayList<User> users = DataLoader.getUsers();

		for(User user : users){
			System.out.println(user);
		}
	}
}



