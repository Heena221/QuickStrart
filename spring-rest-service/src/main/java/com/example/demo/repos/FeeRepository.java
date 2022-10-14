package com.example.demo.repos;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Fee;

public interface FeeRepository extends JpaRepository<Fee, Integer> {
	//this method needs to follow DSL naming convention
	//public List<Fee> findByBranch(String srchString);
	
	//Adding @Qyery and passing query
//	@Query(value="select * from tieto_fee where branch=:srchString",nativeQuery=true)
//	public List<Fee> findByBranchName(@Param("srchString") String srchString);
//	
	//JPQL uses className and propertyName instead of tableName and ColumnName
	@Query(value="From Fee where branch=:srchString",nativeQuery=false)
	public List<Fee> findByBranchName(@Param("srchString") String srchString);
	
	@Query(value="update tieto_fee set amount=:revisedAmount where id=:id",nativeQuery = true)
	@Modifying
	@Transactional
	public int updateAmount(@Param("revisedAmount") double amount,@Param("id")int id);
}
