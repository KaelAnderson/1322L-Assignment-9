package com.company;

public class NegativeDollarAmountException extends Exception{
    public NegativeDollarAmountException(){}
    public NegativeDollarAmountException(String message){
        super(message);
    }
}
