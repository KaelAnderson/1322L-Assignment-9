package com.company;

public class InvalidPasswordFormatException extends Exception{
public InvalidPasswordFormatException(){}
public InvalidPasswordFormatException(String message){
super(message);
}
}
