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
        facade.searchSongs("piano");




        

    }

    public boolean login(){
        System.out.println("Logging in as Fred!");          
        return facade.login("ffred@gmail.com", "securepassword123");  
    }
    
    public boolean logout() {
        return facade.logout();
    }
    // Temporary method to create an account for testing purposes
    public boolean createFirstAccount() {   
        System.out.println("Attempting to create an account for Fred!");
        return facade.createAccount("ffredrickson", "Fellicia", "Fredrickson", "ffredrickson@gmail.com", "securepassword123", scanner); 
    }
    // Temporary method to create an account for testing purposes
    public boolean createSecondAccount() {
        System.out.println("Let's try again!");
        return facade.createAccount("emmasmith", "Fred", "Fredrickson", "ffredrickson@gmail.com", "securepassword123", scanner); 
    }

    public boolean playASong() {
        return facade.playASong();
    }
    
}
    

