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
        // Scenario 1: Create an account, log in, and log out
        User user = UserList.getInstance().getUser("ffredrickson@gmail.com", "securepassword123");
        System.out.println("Existing user details: " + user.toString());
        user = null;
        createFirstAccount();
        createSecondAccount();
        logout();
        login();
    }

    public boolean login(){
        System.out.println("Logging in as Fred!");          
        return facade.login("ffred@gmail.com", "securepassword123");  
    }
    
    public boolean logout() {
        return facade.logout();
    }

    public boolean createFirstAccount() {
        System.out.println("Attempting to create an account for Fred!");
        return facade.createAccount("ffredrickson", "Fred", "Fredrickson", "ffredrickson@gmail.com", "securepassword123", scanner); 
    }

    public boolean createSecondAccount() {
        System.out.println("Let's try again!");
        return facade.createAccount("ffred", "Fred", "Fredrickson", "ffred@gmail.com", "securepassword123", scanner); 
    }

    
    
}
