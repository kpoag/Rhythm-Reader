package com.model;
import java.util.Scanner;

public class RRDriver {
    public RRFacade facade = new RRFacade();
    private Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        RRDriver driver = new RRDriver();
        driver.run();
    }

    public void run() {
        createAccount();
      // login();
      // logout();
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
    public boolean createAccount() {
        try {
            System.out.println("\n=== Account Creation ===");
        
            System.out.print("Enter username: ");
            String userName = scanner.nextLine();

           

            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
        
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
        
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            if (User.isEmailTaken(email)) {
                System.out.println("Email is already registered. Please use a different email.");
                return false;  
            }
            if (!User.isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email address.");
                return false;  
            }
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
    
            User newUser = facade.createAccount(userName, firstName, lastName, email, password, scanner);
        
            if (newUser != null) {
                UserList.getInstance().saveUsers();
                System.out.println("\nAccount creation successful!");
                return true;
            } else {
                System.out.println("\nAccount creation failed.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("An error occurred during account creation: " + e.getMessage());
            return false;
        }
    
    }
    
}
