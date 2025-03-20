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

    public boolean login(){
        try {
            facade.login("johndoe@example.com", "securepassword123");
            User user = facade.getCurrentUser();
            if(user!= null) {
                System.out.println("Successfully signed in! Welcome "+ user.getUserName());
                return true;
            } else {
                System.out.println("Login failed: Invalid credentials. Try again or Create an account. ");
                return false;
            }
        } catch (Exception e) {
            System.out.println("An error occured during login: " + e.getMessage());
            return false;
        }
        
        
    }
    
    public boolean logout() {
        boolean loggedout = facade.logout();
        if(loggedout) {
            System.out.println("You have been logged out. Goodbye!");
            return true;
        }
        return false;
}
    
}
