package com.model;

import java.util.List;
import java.util.Objects;

/**
 * Represents the settings for a user account.
 * This class contains methods to update and retrieve various account settings such as experience level,
 * display name, banner style, profile bio, theme color, language, and content filters.
 */
public class Settings {
    private int experienceLevel;
    private String displayName;
    private String bannerStyle;
    private String profileBio;
    private String themeColor;
    private String language;
    private List<String> contentFilter;


    /**
     * Constructs a new Settings instance with the provided parameters.
     *
     * @param experienceLevel  user's experience level.
     * @param displayName      display name of the user.
     * @param bannerStyle      banner style for the account.
     * @param profileBio       profile biography.
     * @param themeColor       theme color.
     * @param language         language preference.
     * @param contentFilter   a list of content filters.
     */
    public Settings(int experienceLevel, String displayName, String bannerStyle, 
                    String profileBio, String themeColor, String language, List<String> contentFilter) {
        this.experienceLevel = experienceLevel;
        this.displayName = displayName;
        this.bannerStyle = bannerStyle;
        this.profileBio = profileBio;
        this.themeColor = themeColor;
        this.language = language;
        this.contentFilter = contentFilter;
    }

    /**
     * Sets the profile picture.
     *
     * @return a confirmation message that the profile picture has been set.
     */
    public String setProfilePicture() {
        return "Profile picture set.";
    }

     /**
     * Updates the profile biography.
     *
     * @param info  new profile bio information.
     * @return a confirmation message that the profile bio has been updated.
     */
    public String addProfileBio(String info) {
        this.profileBio = info;
        return "Profile bio updated.";
    }

    /**
     * Retrieves the user's experience level.
     *
     * @return the experience level.
     */
    public int getExperienceLevel() {
        return experienceLevel;
    }

     /**
      * Sets the theme color for the account.
      *
      * @param themeColor the new theme color.
      * @return true/false if the theme color was set.
      */
    public boolean setThemeColor(String themeColor) {
        if (themeColor != null) {
            this.themeColor = themeColor;
            return true;
        }
        return false;
        
    }

     /**
     * Updates the content filter with the provided list.
     *
     * @param content the new list of content filters.
     * @return a confirmation message that the content filter has been updated.
     */
    public String filterContent(List<String> content) {
        this.contentFilter = content;
        return "Content filtered.";
    }

    /**
     * Resets the account settings to their default values.
     *
     * @return a confirmation message that the account has been reset.
     */
    public String resetAccount() {
        this.experienceLevel = 0;
        this.displayName = "";
        this.bannerStyle = "";
        this.profileBio = "";
        this.themeColor = "";
        this.language = "";
        this.contentFilter.clear();
        return "Account reset.";
    }

    /**
     * Deletes the account if the provided password is correct.
     *
     * @param password  password to authorize account deletion.
     * @return a message indicating whether the account was deleted or if the password was incorrect.
     */
    public String deleteAccount(String password) {
        if ("correctPassword".equals(password)) {
            return "Account deleted.";
        } else {
            return "Incorrect password.";
        }
    }

    /**
     * Enables or disables dark mode.
     *
     * @param mode 
     * @return the mode that was set.
     */
    public boolean darkMode(boolean mode) {
        if (mode) {
            System.out.println("Dark mode enabled.");
        } else {
            System.out.println("Dark mode disabled.");
        }
        return mode;
    }
    /**
     * Changes the user's username
     * @param newUserName
     * @return
     */

    public boolean changeUsername(User user,String newUsername)
    {

        if (user == null || newUsername == null) return false;
        newUsername = newUsername.trim();
        if (newUsername.isEmpty()) return false;

        List<User> allUsers = UserList.getInstance().getUsers();
        for(User u : allUsers)
        {
            if (Objects.equals(u.getId(), user.getId())) continue;
            if (newUsername.equalsIgnoreCase(u.getUserName())) {
                // already taken
                return false;
            }
        }
        boolean changeApplied= user.setUserName(newUsername);
        if(!changeApplied) return false;

        DataWriter.saveUsers();
        return true;
    }

    public static void main(String[] args) {
        Settings settings = new Settings(1, "John Doe", "Classic", "Bio information", 
                                         "Blue", "English", List.of("Sports", "News"));
        settings.setProfilePicture();
        settings.addProfileBio("Updated bio information.");
        System.out.println("Experience level: " + settings.getExperienceLevel());
        settings.setThemeColor("Red");
        settings.filterContent(List.of("Technology", "Music"));
        settings.resetAccount();
        settings.deleteAccount("correctPassword");
        settings.darkMode(true);
    }
}

    

