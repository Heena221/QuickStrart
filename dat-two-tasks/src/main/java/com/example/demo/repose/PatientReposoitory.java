package com.example.demo.repose;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Patient;

public interface PatientReposoitory extends JpaRepository<Patient, Integer> {

}
