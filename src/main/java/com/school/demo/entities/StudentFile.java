package com.school.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StudentFile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String type;
    @Lob
    Blob data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Blob getData() {
        return data;
    }

    public void setData(Blob data) {
        this.data = data;
    }


//    public void setType(String type) {
//        this.type = type;
//    }


//    public StudentFile(Long id, String name, byte[] data) {
//        this.id = id;
//        this.name = name;
//        this.data = data;
//    }
//    public StudentFile() {
//
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setData(byte[] data) {
//        this.data = data;
//    }
//
//
//}
}