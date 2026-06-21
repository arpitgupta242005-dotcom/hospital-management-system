package com.example.hospitalManagement.service;

import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.exception.ResourceNotFoundException;
import com.example.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Transactional
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        patient.setName(updatedPatient.getName());
        patient.setEmail(updatedPatient.getEmail());
        patient.setGender(updatedPatient.getGender());
        patient.setBirthDate(updatedPatient.getBirthDate());
        patient.setBloodGroup(updatedPatient.getBloodGroup());
        return patient;
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}