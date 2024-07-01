package ru.gb.dataBaseUsers;

public class Engineer implements UserType {
    @Override
    public void performAction() {
        System.out.println("User is an engineer");
    }
}
