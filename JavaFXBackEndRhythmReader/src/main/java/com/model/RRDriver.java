package com.model;
import java.util.Scanner;

public class RRDriver {
    public RRFacade facade = RRFacade.getInstance();
    private Scanner scanner = new Scanner(System.in);

    


    public static void main(String[] args) {
        RRDriver driver = new RRDriver();
        //driver.run();
        driver.scenario3();
    }

    public void run() {
        facade.searchSongs("piano");




        

    }

    public void scenario3()
    {
        login3();
        createSong();
        saveSong();
        playSong();
        logout();
        login();
        searchSong();
        playSong();


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
        return facade.createAccount("ffredrickson", "Fellicia", "Fredrickson", "ffredrickson@gmail.com", "securepassword123", true); 
    }
    // Temporary method to create an account for testing purposes
    public boolean createSecondAccount() {
        System.out.println("Let's try again!");
        return facade.createAccount("emmasmith", "Fred", "Fredrickson", "ffredrickson@gmail.com", "securepassword123", true); 
    }

     public boolean login3(){
        System.out.println("Logging in as Fellicia!");          
        return facade.login("ffredrickson@gmail.com", "securepassword123");  
    }

    public boolean createSong()
    {
        Song newSong = facade.createNewSong(facade.getCurrentUser(), scanner);
        if (newSong != null) {
            newSong.setSongTitle("A horse's journey"); // Set the song title
            //newSong.addMeasure()
            return true;
        } else {
            System.out.println("Failed to create a new song.");
            return false;
        }
    }

    public void playSong()
    {
        facade.playCurrentSong();
    }

    public void saveSong()
    {
        facade.saveCurrentSong();
    }

    public void searchSong()
    {
        facade.searchSongs("A horse's journey");
    }
    
    public boolean playASong() {
        return facade.playSong("testSong", 60, true);
    }
    
}
    

