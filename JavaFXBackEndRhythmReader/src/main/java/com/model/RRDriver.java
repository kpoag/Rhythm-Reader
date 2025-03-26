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
        login();
        //createAccount();
      // login();
      // logout();
    }

    public boolean login(){
        return facade.login("johndoe@example.com", "securepassword123");  
    }
    
    public boolean logout() {
        return facade.logout();
    }

    public boolean createAccount() {
<<<<<<< HEAD
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
        
=======
        String email = "emmasmith@example.com";

        return facade.createAccount("emmassmith", "Emma", "Smith", email, "securepassword123", scanner); 
    }
    
    
>>>>>>> d9eaad1654ceb48e66490bb5444ae68934769ad9
}
    

