package ru.gb.dataBaseUsers;

public class Teacher implements UserType {
    @Override
    public void performAction() {
        System.out.println("User is a teacher");
    }
}
