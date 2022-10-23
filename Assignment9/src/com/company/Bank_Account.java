package com.company;

public class Bank_Account {
    private String name;
    private int accountID;
    private static int numOfAccounts = 0;
    private String userID;
    private String userPass;
    private double accountBal;
    Bank_Account(String inputName, String inputID, String inputPass){
        name = inputName;
        userID = inputID;
        userPass = inputPass;
        accountID = numOfAccounts;
        numOfAccounts++;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserID() {
        return userID;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    public String getUserPass() {
        return userPass;
    }
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
    public double getAccountBal() {
        return accountBal;
    }
    public void setAccountBal(double accountBal) {
        this.accountBal = accountBal;
    }
    public int getAccountID() {
        return accountID;
    }
    public static int getNumOfAccounts() {
        return numOfAccounts;
    }
    public static void decreaseNumOfAccounts(){
        numOfAccounts--;
    }
}
