package com.dentalia.v1.service;

import java.util.List;

import com.dentalia.v1.entity.dto.SavePatient;
import com.dentalia.v1.entity.model.Patient;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient getPatientById(Long idPatient);

    Patient createOnePatient(SavePatient savePatient);

    Patient updatePatientById(Long idPatient, SavePatient savePatient);

    Patient disabledPatientById(Long idPatient);

}
