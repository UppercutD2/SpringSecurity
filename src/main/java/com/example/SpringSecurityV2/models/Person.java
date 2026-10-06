package com.example.SpringSecurityV2.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    @NotEmpty
    private String username;

    @Column(name="year_of_birth")
    @NotNull
    private int birthYear;

    @Column(name="password")
    @NotEmpty
    private String password;

    public Person( )
    {

    }

    public Person( String username, int birthYear) {
        this.username = username;
        this.birthYear = birthYear;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthYear=" + birthYear +
                ", password='" + password + '\'' +
                '}';
    }
}
