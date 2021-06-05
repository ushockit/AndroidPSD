package com.example.myapplication.database.entity;

import com.orm.SugarRecord;

import java.time.LocalDate;

public class Person extends SugarRecord {
    String firstName;
    String lastName;
    long birth;

    public Person() {
    }

    public Person(String firstName, String lastName, long birth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
    }
}
