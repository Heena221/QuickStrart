package com.example.demo.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Fee;
import com.example.demo.services.FeeService;

@RestController
@RequestMapping(path="api/v1/fees")
@CrossOrigin(origins="*")
public class FeeController {
	
	@Autowired
	private FeeService service;
	
	@GetMapping
	public List<Fee> findAll(){
		return this.service.findAll();
	}
	@GetMapping(path="/{id}")
	public Fee findById(@PathVariable("id")int id){
		return this.service.findById(id).
				orElseThrow(()->new RuntimeException("Element not found")); 
	}
	@PostMapping
	public ResponseEntity<Fee> add(@RequestBody Fee entity)throws URISyntaxException,SQLException{
		
		Fee addedEntity=this.service.add(entity);
		int pkey=entity.getId();
		String uri="/api/v1/fees/"+pkey;
		return ResponseEntity.created(new URI(uri)).body(addedEntity);
	}
	@DeleteMapping(path="/{id}")
	public void deleteById(@PathVariable("id")int id) {
		this.service.findById(id).
				orElseThrow(()->new RuntimeException("Element not found")); 
	}
	@PutMapping(path="/{id}/{amount}")
	public ResponseEntity<String> update(@PathVariable("id")int id,@PathVariable("amount")double amount){
		int rowUpdated=this.service.update(id, amount);
		return ResponseEntity.ok("Row updated = "+rowUpdated);
		
//		Fee updateEntity=this.service.update(id,amount);
//		return ResponseEntity.ok().body(updateEntity);
		
	}
	
	@GetMapping(path="/srch/{branchName}")
	public List<Fee> findByBranchName(@PathVariable("branchName")String branchName){
		return this.service.findByBranch(branchName);
				 
	}

}
