package com.model;

public class RRDriver {
    public RRFacade facade = new RRFacade();

    public static void main(String[] args) {
        RRDriver driver = new RRDriver();
        driver.run();
    }

    public void run() {
       login();
       logout();
    }

    public void login(){
        try {
            facade.login("johndoe@example.com", "securepassword123");
            User user = facade.getCurrentUser();
            if(user!= null) {
                System.out.println("Successfully signed in! Welcome "+ user.getUserName());
            } else {
                System.out.println("Login failed: Invalid credentials. Try again or Create an account. ");
            }
        } catch (Exception e) {
            System.out.println("An error occured during login: " + e.getMessage());
        }
        
        
    }
    
    public void logout() {
        boolean loggedout = facade.logout();
        if(loggedout) {
            System.out.println("You have been logged out. Goodbye!");
        }
}
    
}
