package com.example.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "doctor_tbl")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment id
    private Long id;

    @Column(nullable = false, length = 48)
    private String name;

    @Column(nullable = false)
    private String specialization;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}