package ru.gb.dataBaseUsers;

public class Driver implements UserType{
    @Override
    public void performAction() {
        System.out.println("User is a driver");
    }
}

