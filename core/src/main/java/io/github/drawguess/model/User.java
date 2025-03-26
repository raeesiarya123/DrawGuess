package io.github.drawguess.model;

public class User {
    private int userID;
    private String username;
    private String email;


    // Konstruktør
    public User(int userID, String username, String email) {
        this.userID = userID;
        this.username = username;
        this.email = email;

    }

    // Gettere
    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


    // Settere
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    // Metode for å vise brukerens informasjon
    public String displayUserInfo() {
        return "User ID: " + userID + ", Username: " + username + ", Email: " + email;
    }
}