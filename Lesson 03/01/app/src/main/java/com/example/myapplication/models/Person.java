package com.example.myapplication.models;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private LocalDate birth;
    private String imagePath;

    public Person(String firstName, String lastName, LocalDate birth, String imagePath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.imagePath = imagePath;
    }

}
