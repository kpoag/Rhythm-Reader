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
        //login();
        playASong();
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
        String email = "emmasmith@example.com";

        return facade.createAccount("emmassmith", "Emma", "Smith", email, "securepassword123", scanner); 
    }

    public boolean playASong() {
        return facade.playASong();
    }
    
    
}
    

