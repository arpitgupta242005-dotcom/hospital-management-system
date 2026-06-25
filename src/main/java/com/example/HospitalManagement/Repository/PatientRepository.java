package com.example.hospitalManagement.repository;

import com.example.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.gender = :gender")
    List<Patient> findByGender(@Param("gender") String gender);

    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = :bloodGroup")
    List<Patient> findByBloodGroup(@Param("bloodGroup") String bloodGroup);

    @Query(value = "SELECT * FROM patient_tbl WHERE name ILIKE %:name%", nativeQuery = true)
    List<Patient> searchByName(@Param("name") String name);
}