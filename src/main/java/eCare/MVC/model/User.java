package eCare.MVC.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class User {

    private int userId;

    private String name;

    private String secondName;

    private String birthdayData;

    private String passport;

    private String address;

    private double balance;

    private String password;

    private String accessLevel;

    private String contracts;

    public User(int userId, String name, String secondName, String birthdayData, String passport, String address, double balance, String password, String accessLevel, String contracts) {
        this.userId = userId;
        this.name = name;
        this.secondName = secondName;
        this.birthdayData = birthdayData;
        this.passport = passport;
        this.address = address;
        this.balance = balance;
        this.password = password;
        this.accessLevel = accessLevel;
        this.contracts = contracts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirthdayData() {
        return birthdayData;
    }

    public void setBirthdayData(String birthdayData) {
        this.birthdayData = birthdayData;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getContracts() {
        return contracts;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthdayData='" + birthdayData + '\'' +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                ", contracts='" + contracts + '\'' +
                '}';
    }
}

