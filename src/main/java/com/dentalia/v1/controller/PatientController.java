package com.dentalia.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dentalia.v1.entity.dto.SavePatient;
import com.dentalia.v1.entity.model.Patient;
import com.dentalia.v1.service.PatientService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patientList = patientService.getAllPatients();
        return ResponseEntity.ok(patientList);
    }

    @GetMapping("/{idPatient}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long idPatient) {
        Patient patient = patientService.getPatientById(idPatient);
        return ResponseEntity.ok(patient);
    }

    @PostMapping("")
    public ResponseEntity<Patient> createOnePatient(@RequestBody SavePatient savePatient) {
        Patient patient = patientService.createOnePatient(savePatient);
        return ResponseEntity.ok(patient);
    }

    @PutMapping("/{idPatient}")
    public ResponseEntity<Patient> updatePatientById(@PathVariable Long idPatient, @RequestBody SavePatient savePatient) {
        Patient patientFromDB = patientService.updatePatientById(idPatient,savePatient);
        return ResponseEntity.ok(patientFromDB);
    }

    @PutMapping("/disabled/{idPatient}")
    public ResponseEntity<Patient> disabledPatientById(@PathVariable Long idPatient) {
        Patient patientFromDB = patientService.disabledPatientById(idPatient);
        return ResponseEntity.ok(patientFromDB);
    }
    
}
