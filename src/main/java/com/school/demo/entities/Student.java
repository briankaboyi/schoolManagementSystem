package com.school.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "studentTable")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    @Column(name = "studentName")
    String name;
    int age;
    @Column(unique = true)
    String email;
    String phoneNubmer;
    public Student( String name, int age, String email, String phoneNubmer) {

        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNubmer = phoneNubmer;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNubmer() {
        return phoneNubmer;
    }

    public void setPhoneNubmer(String phoneNubmer) {
        this.phoneNubmer = phoneNubmer;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
