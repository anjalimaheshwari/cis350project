package com.example.personalwellness;

import android.os.AsyncTask;

import java.net.URL;
import java.util.List;

public class User {

    private String name, username, password;
    private int accountNum = 0 , mentalHealth = 0, stress = 0, diet = 0,
            fitness = 0, community = 0, sleep = 0;
    private List<Resource> personalRecs = null;

    private static int uniqueNum = 0;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.accountNum = uniqueNum;
        uniqueNum++;
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

    public int getDiet() {
        return diet;
    }

    public int getFitness() {
        return fitness;
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
        stress += update;
    }

    public void updateMentalHealth(int update) {
        mentalHealth += update;
    }

    public void updateDiet(int update) {
        diet += update;
    }

    public void updateFitness(int update) {
        fitness += update;
    }

    public void updateSleep(int update) {
        sleep += update;
    }

    public void updateCommunity(int update) {
        community += update;
    }

    public void updatePersonalRecs(List<Resource> personalRecs) { this.personalRecs = personalRecs; }



}
