package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.repose.DoctorRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class DoctorService {
	private DoctorRepository repo;
	
	public Doctor add(Doctor entity) {
		return this.repo.save(entity);
		
	}
	public Doctor findById(int id)  {
		return this.repo.findById(id).orElseThrow(()->
		new ElementNotFoundException("ERR-102","Element(Doctor) Not Found"));
	}
}
