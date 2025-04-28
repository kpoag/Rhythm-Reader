package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import com.model.RRFacade;
import com.model.User;
import com.model.DataWriter;
import com.model.UserList;
import com.rhythmreader.App;

public class friendsController {
    
    @FXML private TextField searchField;
    @FXML private ListView<String> searchResultsList;
    @FXML private ListView<String> friendsList;
    @FXML private ListView<String> requestsList;
    
    private RRFacade facade;
    private User currentUser;
    private ObservableList<String> friends;
    private ObservableList<String> searchResults;
    private ObservableList<String> friendRequests;
    
    @FXML
    private void initialize() {
        facade = RRFacade.getInstance();
        currentUser = facade.getCurrentUser();
        
        // Initialize observable lists
        friends = FXCollections.observableArrayList();
        searchResults = FXCollections.observableArrayList();
        friendRequests = FXCollections.observableArrayList();
        
        // Set up list views
        friendsList.setItems(friends);
        searchResultsList.setItems(searchResults);
        requestsList.setItems(friendRequests);
        
        // Load current user's friends
        loadFriends();
        
        // Load friend requests
        loadFriendRequests();
        
        // Set up custom cell factories for the list views
        setupListViewCellFactories();
    }
    
    private void loadFriends() {
        // Get friends list from current user
        if (currentUser != null) {
            // Assuming User class has a method to get friends
            ArrayList<String> userFriends = currentUser.getFriends();
            if (userFriends != null) {
                friends.setAll(userFriends);
            }
        }
    }
    
    private void loadFriendRequests() {
        // Get friend requests for current user
        if (currentUser != null) {
            // Assuming User class has a method to get friend requests
            ArrayList<String> requests = currentUser.getFriendRequests();
            if (requests != null) {
                friendRequests.setAll(requests);
            }
        }
    }
    
    /**
     * Helper method to find a user by username
     */
    private User findUserByUsername(String username) {
        if (username == null || username.isEmpty()) {
            return null;
        }
        
        ArrayList<User> allUsers = UserList.getInstance().getUsers();
        for (User user : allUsers) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    private void setupListViewCellFactories() {
        // Custom cell factory for search results
        searchResultsList.setCellFactory(lv -> new ListCell<String>() {
            private final Button addButton = new Button("Add Friend");
            private final HBox content = new HBox(10);
            
            {
                content.getChildren().addAll(new Label(""), addButton);
                HBox.setHgrow(content.getChildren().get(0), Priority.ALWAYS);
                addButton.setOnAction(event -> handleAddFriend(getItem()));
            }
            
            @Override
            protected void updateItem(String username, boolean empty) {
                super.updateItem(username, empty);
                if (empty || username == null) {
                    setGraphic(null);
                } else {
                    ((Label)content.getChildren().get(0)).setText(username);
                    setGraphic(content);
                }
            }
        });
        
        // Custom cell factory for friends list
        friendsList.setCellFactory(lv -> new ListCell<String>() {
            private final Button removeButton = new Button("Remove");
            private final HBox content = new HBox(10);
            
            {
                content.getChildren().addAll(new Label(""), removeButton);
                HBox.setHgrow(content.getChildren().get(0), Priority.ALWAYS);
                removeButton.setOnAction(event -> handleRemoveFriend(getItem()));
            }
            
            @Override
            protected void updateItem(String username, boolean empty) {
                super.updateItem(username, empty);
                if (empty || username == null) {
                    setGraphic(null);
                } else {
                    ((Label)content.getChildren().get(0)).setText(username);
                    setGraphic(content);
                }
            }
        });
        
        // Custom cell factory for friend requests
        requestsList.setCellFactory(lv -> new ListCell<String>() {
            private final Button acceptButton = new Button("Accept");
            private final Button declineButton = new Button("Decline");
            private final HBox content = new HBox(10);
            
            {
                content.getChildren().addAll(new Label(""), acceptButton, declineButton);
                HBox.setHgrow(content.getChildren().get(0), Priority.ALWAYS);
                acceptButton.setOnAction(event -> handleAcceptRequest(getItem()));
                declineButton.setOnAction(event -> handleDeclineRequest(getItem()));
            }
            
            @Override
            protected void updateItem(String username, boolean empty) {
                super.updateItem(username, empty);
                if (empty || username == null) {
                    setGraphic(null);
                } else {
                    ((Label)content.getChildren().get(0)).setText(username);
                    setGraphic(content);
                }
            }
        });
    }
    
    @FXML
    private void searchFriends() {
        String searchTerm = searchField.getText().trim();
        if (!searchTerm.isEmpty()) {
            // Clear previous results
            searchResults.clear();
            
            // Get all users that match the search term
            ArrayList<String> results = searchUsers(searchTerm);
            if (results != null) {
                // Filter out current user and existing friends
                results.removeIf(username -> 
                    username.equals(currentUser.getUserName()) || 
                    friends.contains(username)
                );
                searchResults.addAll(results);
            }
        }
    }
    
    // Helper method to search users since RRFacade might not have this method
    private ArrayList<String> searchUsers(String searchTerm) {
        ArrayList<String> results = new ArrayList<>();
        ArrayList<User> allUsers = UserList.getInstance().getUsers();
        
        for (User user : allUsers) {
            if (user.getUserName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                user.getEmail().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(user.getUserName());
            }
        }
        
        return results;
    }
    
    private void handleAddFriend(String username) {
        if (username != null && currentUser != null) {
            // Send friend request
            User targetUser = findUserByUsername(username);
            if (targetUser != null) {
                // Add to target user's friend requests
                targetUser.addFriendRequest(currentUser.getUserName());
                // Save changes
                DataWriter.saveUsers();
                
                searchResults.remove(username);
                // Show success message
                showAlert("Friend Request Sent", 
                         "Friend request sent to " + username, 
                         Alert.AlertType.INFORMATION);
            }
        }
    }
    
    private void handleRemoveFriend(String username) {
        if (username != null && currentUser != null) {
            // Remove friend
            currentUser.removeFriend(username);
            
            // Also remove current user from the other user's friends list
            User friend = findUserByUsername(username);
            if (friend != null) {
                friend.removeFriend(currentUser.getUserName());
            }
            
            // Save changes
            DataWriter.saveUsers();
            
            friends.remove(username);
            // Show success message
            showAlert("Friend Removed", 
                     username + " has been removed from your friends list", 
                     Alert.AlertType.INFORMATION);
        }
    }
    
    private void handleAcceptRequest(String username) {
        if (username != null && currentUser != null) {
            // Accept friend request
            currentUser.removeFriendRequest(username);
            currentUser.addFriend(username);
            
            // Add current user to the requester's friends list
            User requester = findUserByUsername(username);
            if (requester != null) {
                requester.addFriend(currentUser.getUserName());
            }
            
            // Save changes
            DataWriter.saveUsers();
            
            friendRequests.remove(username);
            friends.add(username);
            // Show success message
            showAlert("Friend Request Accepted", 
                     username + " has been added to your friends list", 
                     Alert.AlertType.INFORMATION);
        }
    }
    
    private void handleDeclineRequest(String username) {
        if (username != null && currentUser != null) {
            // Decline friend request
            currentUser.removeFriendRequest(username);
            
            // Save changes
            DataWriter.saveUsers();
            
            friendRequests.remove(username);
            // Show success message
            showAlert("Friend Request Declined", 
                     "Friend request from " + username + " has been declined", 
                     Alert.AlertType.INFORMATION);
        }
    }
    
    @FXML
    private void navigateToHome() throws IOException {
        App.navigateTo("userDashboard");
    }
    
    private void showAlert(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
