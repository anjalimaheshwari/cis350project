package com.example.personalwellness;

import android.os.AsyncTask;

import java.net.URL;
import java.util.List;

public class User {

    private String name, username, password;
    private int accountNum = 0 , mentalHealth = 0, stress = 0, physicalHealth = 0, community = 0, sleep = 0;
    private List<Resource> personalRecs = null;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public int getMentalHealth() {
        return mentalHealth;
    }

    public int getStress() {
        return stress;
    }

    public int getPhysicalHealth() {
        return physicalHealth;
    }

    public int getSleep() {
        return  sleep;
    }

    public int getCommunity() {
        return community;
    }

    public boolean isPassword(String password) {
        return this.password.equals(password);
    }

    public void updateStress(int update) {
        stress = update;
    }

    public void updateMentalHealth(int update) {
        mentalHealth = update;
    }

    public void updatePhysicalHealth(int update) {
        physicalHealth = update;
    }

    public void updateSleep(int update) {
        sleep = update;
    }

    public void updateCommunity(int update) {
        community = update;
    }

    public void updatePersonalRecs(List<Resource> personalRecs) { this.personalRecs = personalRecs; }

    public void updateAccountNum(int update) {
        accountNum = update;
    }



}
