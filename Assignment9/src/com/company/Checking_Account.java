package com.company;

public class Checking_Account extends  Bank_Account{
    private double dailyWithdrawalLimit;
    Checking_Account(String inputName, String inputID, String inputPass) {
        super(inputName, inputID, inputPass);
        dailyWithdrawalLimit = 300;
    }
    public double getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }
    public void setDailyWithdrawalLimit(double dailyWithdrawalLimit) {
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
    }
}
