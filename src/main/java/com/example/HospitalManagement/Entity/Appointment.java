package com.example.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "appointment_tbl")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //patient relationship
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)//Foreign key column define karne ke liye.
    private com.example.hospitalManagement.entity.Patient patient;

    //doctor relationship
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private com.example.hospitalManagement.entity.Doctor doctor;

    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    private com.example.hospitalManagement.entity.AppointmentStatus status;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
//foregin key dusari table ke record ko reference karti hai
//Database me Patient object store hota hai ya patient_id?--Sirf patient_id (foreign key) store hota hai.