package com.model;

import java.util.List;

public class Settings {
    private int experienceLevel;
    private String displayName;
    private String bannerStyle;
    private String profileBio;
    private String themeColor;
    private String language;
    private List<String> contentFilter;

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

    public void setProfilePicture() {
        System.out.println("Profile picture set.");
    }

    public String addProfileBio(String info) {
        this.profileBio = info;
        return "Profile bio updated.";
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    public void filterContent(List<String> content) {
        this.contentFilter = content;
        System.out.println("Content filtered.");
    }

    public void resetAccount() {
        this.experienceLevel = 0;
        this.displayName = "";
        this.bannerStyle = "";
        this.profileBio = "";
        this.themeColor = "";
        this.language = "";
        this.contentFilter.clear();
        System.out.println("Account reset.");
    }

    public void deleteAccount(String password) {
        if ("correctPassword".equals(password)) {
            System.out.println("Account deleted.");
        } else {
            System.out.println("Incorrect password.");
        }
    }

    public boolean darkMode(boolean mode) {
        if (mode) {
            System.out.println("Dark mode enabled.");
        } else {
            System.out.println("Dark mode disabled.");
        }
        return mode;
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

    

