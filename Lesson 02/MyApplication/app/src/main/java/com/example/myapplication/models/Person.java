package com.example.myapplication.models;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String imagePath;

    public Person() {
    }

    public Person(String firstName, String lastName, int age, String imagePath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.imagePath = imagePath;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
