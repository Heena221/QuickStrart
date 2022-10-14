package com.example.demo.repose;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	//public List<Doctor> findById(int id);

}
