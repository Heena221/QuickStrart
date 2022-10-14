package com.example.demo.repose;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Hospital;


public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	
	public List<Hospital> findById(int id);


}
