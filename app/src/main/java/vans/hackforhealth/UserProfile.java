package vans.hackforhealth;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sarthak on 4/9/17.
 */

public class UserProfile {
    String name;
    String email;
    String pass;
    String dob;
    char gender;
    String bio;
    ArrayList<String> interests;
    String disorder;

    public UserProfile(String name, String email, String pass, String dob, char gender, String bio, String interests, String disorder) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.dob = dob;
        this.gender = gender;
        this.bio = bio;
        this.interests = new ArrayList<String>(Arrays.asList(interests.split(",")));

        this.disorder = disorder;

        System.out.print("Constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

    public String getDisorder() {
        return disorder;
    }

    public void setDisorder(String disorder) {
        this.disorder = disorder;
    }
}
