package com.dentalia.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dentalia.v1.entity.dto.SavePatient;
import com.dentalia.v1.entity.model.Patient;
import com.dentalia.v1.repository.PatientRepository;

@Service
public class PatientServiceImp implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long idPatient) {
        return patientRepository.findById(idPatient)
                                .orElseThrow();
    }

    @Override
    public Patient createOnePatient(SavePatient savePatient) {
        Patient newPatient = Patient.builder()
                                    .name(savePatient.getName())
                                    .lastname(savePatient.getLastname())
                                    .email(savePatient.getEmail())
                                    .phone(savePatient.getPhone())
                                    .emergency_phone(savePatient.getEmergency_phone())
                                    .status(Patient.Status.ENABLED)
                                    .build();
        return patientRepository.save(newPatient);
    }

    @Override
    public Patient updatePatientById(Long idPatient, SavePatient savePatient) {
        Patient patientFromDB = patientRepository.findById(idPatient)
                                                 .orElseThrow();
        patientFromDB.setName(savePatient.getName());
        patientFromDB.setLastname(savePatient.getLastname());
        patientFromDB.setEmail(savePatient.getEmail());
        patientFromDB.setPhone(savePatient.getPhone());
        patientFromDB.setEmergency_phone(savePatient.getEmergency_phone());
        System.out.println(patientFromDB.getName());
        return patientRepository.save(patientFromDB);
    }

    @Override
    public Patient disabledPatientById(Long idPatient) {
        Patient patientFromDB = patientRepository.findById(idPatient)
                                                 .orElseThrow();
        patientFromDB.setStatus(Patient.Status.DISABLED);
        return patientRepository.save(patientFromDB);
    }

}
