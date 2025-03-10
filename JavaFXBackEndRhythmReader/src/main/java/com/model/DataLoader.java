package com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
				/* 
				String classroom = (String)personJSON.get(USER_CLASSROOM);
				Module assignedModules = (Module)personJSON.get(USER_ASSIGNED_MODULES);
				Module completedModules = (Module)personJSON.get(USER_COMPLETED_MODULES);
				Module currentModule = (Module)personJSON.get(USER_CURRENT_MODULE);
				Module recommendedModules = (Module)personJSON.get(USER_RECOMMENDED_MODULES);
				String deadlines = (String)personJSON.get(USER_DEADLINES);
				String grades = (String)personJSON.get(USER_GRADES);
				String progress = (String)personJSON.get(USER_PROGRESS);
				DifficultyLevel skillLevel = (DifficultyLevel)personJSON.get(USER_SKILL_LEVEL);
				String teachingClasses = (String)personJSON.get(USER_TEACHING_CLASSES); */
				JSONArray badgesJSON = (JSONArray)personJSON.get(USER_BADGES);
				ArrayList<String> badges = new ArrayList<>();

				for(int j=0; j < badgesJSON.size(); j++) {
					badges.add((String)badgesJSON.get(j));
				}

				JSONArray friendsJSON = (JSONArray)personJSON.get(USER_FRIENDS);
				ArrayList<String> friendIds = new ArrayList<>();
				if (friendsJSON != null) {
					for(int p=0; p < friendsJSON.size(); p++) {
						friendIds.add((String)friendsJSON.get(p));
					}
				}
				


				
				
				users.add(new User(id, userName, firstName, lastName, email, password, points, badges, friendIds));
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}

	public static void main(String[] args) {
		ArrayList<User> users = DataLoader.getUsers();
	
		// Basic check to see if users are loaded
		if (users == null || users.isEmpty()) {
			System.out.println("No users loaded. Check the JSON file or parsing logic.");
			return;
		}
		// Used to display username of a User's friend
		Map<String, User> userMap = new HashMap<>();
		for (User user : users) {
			userMap.put(user.getId().toString(), user);
		}
	
		// Additional checks for specific fields
		User testUser = users.get(0); // Assuming at least one user is present
		System.out.println("\nTesting first user:");
		System.out.println("Username: " + testUser.getUserName());
		System.out.println("First Name: " + testUser.getFirstName());
		System.out.println("Last Name: " + testUser.getLastName());
		System.out.println("Email: " + testUser.getEmail());
		System.out.println("Password: " + testUser.getPassword());
		System.out.println("Badges: " + testUser.getBadges());
		System.out.println("Points: " + testUser.getPoints());
		System.out.println("Friends: " + testUser.getFriendNames(userMap));

		
		// Check for null or unexpected values
		if (testUser.getUserName() == null) {
			System.out.println("Error: Username is null.");
		}
		if (testUser.getPoints() < 0) {
			System.out.println("Error: Points cannot be negative.");
		}
	}

}



