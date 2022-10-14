package com.example.demo.services;

import java.util.List;

//import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Hospital;
import com.example.demo.repose.HospitalRepository;

@Service
public class HospitalServices {
	@Autowired
	//private JdbcTemplate jdbcTemplate;
	private HospitalRepository repo;
	@Autowired
	public HospitalServices(HospitalRepository repo) {
		super();
		this.repo=repo;
	}
	public Hospital save(Hospital entity) {
		return  this.repo.save(entity);
		}
	public List<Hospital> findAll(){
		return this.repo.findAll();
	}
	public List<Hospital> findById(int id){
		return this.repo.findById(id);
	}
	public Hospital update(Hospital entity){
		return  this.repo.save(entity);
	}

	public void deleteById(int id){
		  this.repo.deleteById(id);
	}
//	@Transactional
//	public int update(String hospitalName,int id) {
//		String sql="update hospital set hospital_name=? where id=?";
//		int numberOfRowsAffected=jdbcTemplate.update(sql,hospitalName,id);
//	 return numberOfRowsAffected;
//	}
//	@Transactional
//	public int delete(int id) {
//		String sql="delete from hospital where id=?";
//		int numberOfRowsAffected=jdbcTemplate.update(sql,id);
//	 return numberOfRowsAffected;
//	}
	
	
	
	

}
