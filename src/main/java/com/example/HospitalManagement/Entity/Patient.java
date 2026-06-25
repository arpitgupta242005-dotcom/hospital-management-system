package com.example.hospitalManagement.entity;

import com.example.HospitalManagement.Entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(
        name="patient_tbl",
        uniqueConstraints = {
                //dublicate add nahi karega
                @UniqueConstraint(name="unique_patient_email",columnNames = {"email"}),
                @UniqueConstraint(name="unique_patient_name_birthdate",columnNames={"name","birthDate"})
        },
        indexes={
                //search fast karta he
                @Index(name="idx_patient_birth_date",columnList="birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 48)
    private String name;

    @ToString.Exclude
    private LocalDateTime birthDate;

    @Column(unique = true,nullable = false)
    private String email;
    private String gender;

    @CreationTimestamp//Automatically current time insert.
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;
}