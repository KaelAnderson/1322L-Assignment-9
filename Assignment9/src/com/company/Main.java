package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

	boolean cont = true;
        ArrayList<Bank_Account> bankAccounts = new ArrayList<>();
    do{
    System.out.println("1 – Create An Account\n" +
            "2 – Delete An Account\n" +
            "3 – Make An Account Deposit\n" +
            "4 – Make An Account Withdrawal\n" +
            "5 – Check An Account Balance\n" +
            "6 – Exit\n" +
            "Enter Choice:");
    String inputName;
    String inputID;
    String inputPass;
    boolean isreal = false;
    double inputAmount;
    String choice = scan.next();
    try {
        if(Integer.parseInt(choice) < 1 || Integer.parseInt(choice) > 6){
            throw new Exception("Please enter a valid choice (1 thru 6)");
        }
    }
    catch (Exception e){
        System.out.println("Error: " + e);
    }
        switch (choice){
            case "1":
                    scan.nextLine();
                    System.out.print("\nEnter Customer Name: ");
                    inputName = scan.nextLine();

                    System.out.print("Enter User ID: ");
                    inputID = scan.nextLine();

                    System.out.print("Enter User Password: ");
                    inputPass = scan.nextLine();

                    boolean goodPass = false;
                    for(int i = 0; i < inputPass.length(); i++){
                        if (inputPass.charAt(i) == '*'){
                            goodPass = true;
                        }
                    }
                    try {
                        if(!goodPass || inputPass.length() < 8){
                            throw new InvalidPasswordFormatException("Must Enter a Valid Password");
                        }
                    }
                    catch (Exception e){
                        System.out.println("Error: " + e);
                        System.out.println("InvalidPasswordFormatException: Invalid Password Format");
                    }

                    bankAccounts.add(new Checking_Account(inputName,inputID,inputPass));

                break;
            case "2":
                scan.nextLine();
                System.out.print("\nEnter User ID: ");
                inputID = scan.nextLine();
                System.out.print("Enter User Password: ");
                inputPass = scan.nextLine();
                isreal = false;
                for(int i = 0;i < bankAccounts.size(); i++){
                    if(inputID.equals(bankAccounts.get(i).getUserID()) && inputPass.equals(bankAccounts.get(i).getUserPass())){
                        bankAccounts.remove(i);
                        Bank_Account.decreaseNumOfAccounts();
                        isreal = true;
                    }
                }
                try {
                    if(!isreal){
                        throw new CustomerAccountNotFoundException("Must Enter a Valid User ID and Password");
                    }
                }
                catch (Exception e){
                    System.out.println("Error: " + e);
                    System.out.println("CustomerAccountNotFoundException: Customer Account Not Found");
                }
                break;
            case "3":
                try {
                    scan.nextLine();
                    System.out.print("\nEnter User ID: ");
                    inputID = scan.nextLine();
                    System.out.print("Enter User Password: ");
                    inputPass = scan.nextLine();

                    isreal = false;
                    for (int i = 0; i < bankAccounts.size(); i++) {
                        if (inputID.equals(bankAccounts.get(i).getUserID()) && inputPass.equals(bankAccounts.get(i).getUserPass())) {
                            System.out.print("Enter Amount: ");
                            inputAmount = scan.nextDouble();
                            isreal = true;
                            if (inputAmount >= 0) {
                                bankAccounts.get(i).setAccountBal(bankAccounts.get(i).getAccountBal() + inputAmount);
                            } else {
                                throw new NegativeDollarAmountException("Must Enter a Positive Dollar Amount");
                            }
                        }
                    }
                    if (isreal == false) {
                        throw new CustomerAccountNotFoundException("Must Enter a Valid User ID and Password");
                    }
                }
                catch (Exception e){
                System.out.println("Error: " + e);
                if(e.getMessage().equals("Must Enter a Positive Dollar Amount")){
                    System.out.println("NegativeDollarAmountException: Negative Dollar Amount");
                }
                if(e.getMessage().equals("Must Enter a Valid User ID and Password")){
                    System.out.println("CustomerAccountNotFoundException: Customer Account Not Found");
                }
                }
                break;
            case "4":
                scan.nextLine();
                System.out.print("\nEnter User ID: ");
                inputID = scan.nextLine();
                System.out.print("Enter User Password: ");
                inputPass = scan.nextLine();


                isreal = false;
                for(int i = 0;i < bankAccounts.size(); i++){
                    if(inputID.equals(bankAccounts.get(i).getUserID()) && inputPass.equals(bankAccounts.get(i).getUserPass())){
                        System.out.print("Enter Amount: ");
                        inputAmount = scan.nextDouble();
                        isreal = true;
                        try {
                            if(bankAccounts.get(i).getAccountBal() - inputAmount < 0){
                                throw new InsufficientFundsException("Must Withdraw an Amount Less Than Your Balance");
                            }else {
                                if (inputAmount >= 0) {
                                    bankAccounts.get(i).setAccountBal(bankAccounts.get(i).getAccountBal() - inputAmount);
                                } else {
                                    throw new NegativeDollarAmountException("Must Enter a Positive Dollar Amount");
                                }
                            }
                        }
                        catch (Exception e){
                            System.out.println("Error: " + e);
                            if(e.getMessage().equals("Must Enter a Positive Dollar Amount")){
                                System.out.println("NegativeDollarAmountException: Negative Dollar Amount");
                            }
                            if(e.getMessage().equals("Must Enter a Valid User ID and Password")){
                                System.out.println("CustomerAccountNotFoundException: Customer Account Not Found");
                            }
                        }
                    }
                }
                try {
                    if(isreal == false){
                        throw new CustomerAccountNotFoundException("Must Enter a Valid User ID and Password");
                    }
                }
                catch (Exception e){
                    System.out.println("Error: " + e);
                    if(e.getMessage().equals("Must Enter a Valid User ID and Password")){
                        System.out.println("CustomerAccountNotFoundException: Customer Account Not Found");
                    }
                }
                break;
            case "5":
                scan.nextLine();
                System.out.print("\nEnter User ID: ");
                inputID = scan.nextLine();
                System.out.print("Enter User Password: ");
                inputPass = scan.nextLine();
                isreal = false;
                for(int i = 0;i < bankAccounts.size(); i++){
                    if(inputID.equals(bankAccounts.get(i).getUserID()) && inputPass.equals(bankAccounts.get(i).getUserPass())){
                        isreal = true;
                        System.out.println("Customer Name: " + bankAccounts.get(i).getName() + "\n" +
                                "Account Number: " + bankAccounts.get(i).getAccountID() + "\n" +
                                "Account Balance: " + bankAccounts.get(i).getAccountBal());

                                if(bankAccounts.get(i) instanceof Checking_Account){
                                    System.out.println("Account Type: Checking Account");
                                    System.out.println("Account Daily Withdrawal Limit: " + ((Checking_Account) bankAccounts.get(i)).getDailyWithdrawalLimit());
                                }else {
                                    System.out.println("Account Type: Bank Account");
                                }
                    }
                }
                try {
                    if(!isreal){
                        throw new CustomerAccountNotFoundException("Must Enter a Valid User ID and Password");
                    }
                }
                catch (Exception e){
                    System.out.println("Error: " + e);
                    if(e.getMessage().equals("Must Enter a Valid User ID and Password")){
                        System.out.println("CustomerAccountNotFoundException: Customer Account Not Found");
                    }
                }
                break;
            case "6":
                cont = false;
                break;
        }
    }while(cont);
    }
}
