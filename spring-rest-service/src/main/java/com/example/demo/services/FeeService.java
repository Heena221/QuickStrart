package com.example.demo.services;

import com.example.demo.repos.FeeRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Fee;
@Service
public class FeeService {
	
	@Autowired
	private FeeRepository repo;
	public FeeService() {
		super();
	}
	public Fee add(Fee entity) throws SQLException {
        return this.repo.save(entity);
    }
  public List<Fee> findAll(){
	  return this.repo.findAll();
	  }
  public Optional<Fee> findById(int key){
	  return this.repo.findById(key);
	  }
  public void deleteById(int key) { 
	  if(this.repo.existsById(key)) {
		  this.repo.deleteById(key);  
	  }
	  else{
		 throw new RuntimeException("Element Not Found"); 
	  }
	   
  }
  public int update(int id,double amount) {
		return this.repo.updateAmount(amount,id);	
	}
  public List<Fee> findByBranch(String branchName){
	  return this.repo.findByBranchName(branchName);
  }
  
}

//update
//insert
//upsert=save
