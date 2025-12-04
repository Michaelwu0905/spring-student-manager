package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique=true, length=20)
    private String studentNo;

    @Column(length = 10)
    private String gender;

    private Integer age;

    @Column(length = 100)
    private String major;

    @Column(length = 50)
    private String className;

    @Column(length = 200)
    private String email;

}
