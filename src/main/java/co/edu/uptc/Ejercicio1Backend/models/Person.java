package co.edu.uptc.Ejercicio1Backend.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Person {
    private String index;
    private String userId;
    private String firstName;
    private String lastName;
    private String sex;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String jobTitle;
    private int age;

}