package com.example.demo.repos;

import java.util.*;

import com.example.demo.entity.Fee;
import com.example.demo.utils.ConnectionFactory;

import java.sql.*;
public class FeeRepository {
	Connection con=null;
	private static String insertSql="insert into tieto_fee values(?,?,?,?)";
	private static String findAllSql="select * from tieto_fee ";
	private static String findByIdSql="select * from tieto_fee where id=?";
	private static String removeByIdSql="delete from tieto_fee where id=?";
	private static String updateByBranchSql="update tieto_fee set amount=? where branch=?";
	public FeeRepository() {
		super();
		this.con=ConnectionFactory.getMySqlConnection();
	}
	public int add(Fee entity) throws SQLException{
		int rowAdded=0;
		try(PreparedStatement pstmt=con.prepareStatement(insertSql)){
			
			pstmt.setInt(1,entity.getId());
			pstmt.setString(2, entity.getBranch());
			pstmt.setString(3, entity.getYear());
			pstmt.setDouble(4, entity.getAmount());
			
			rowAdded=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			 throw e;
		}
		return rowAdded;
		
	}
	
	public List<Fee> findAll(){
		List <Fee> list=new ArrayList<>();
try(PreparedStatement pstmt=con.prepareStatement(findAllSql)){
			
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()) {
		int id=rs.getInt("id");
		String branch=rs.getString("branch");
		String year=rs.getString("year");
		double amount=rs.getDouble("amount");
		Fee rowRef=new Fee(id,branch,year,amount);
		list.add(rowRef);	
	}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public Optional<Fee> findById(int key) {
		Optional<Fee> found=Optional.empty();
		try(PreparedStatement pstmt=con.prepareStatement(findByIdSql)){
			pstmt.setInt(1, key);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int id=rs.getInt("id");
				String branch=rs.getString("branch");
				String year=rs.getString("year");
				double amount=rs.getDouble("amount");
				Fee foundObject =new Fee(id,branch,year,amount);
				found=Optional.of(foundObject);	
			}
					
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
		return found;
	}
	public int remove(int id) {
		int rowDeleted=0;
		try(PreparedStatement pstmt=con.prepareStatement(removeByIdSql)){
			pstmt.setInt(1, id);
			rowDeleted=pstmt.executeUpdate();
			}catch(SQLException e) {
					e.printStackTrace();
				}
		return rowDeleted;
	}
	public int update(String branch,double amount) {
		int rowsUpdated=0;
		try(PreparedStatement pstmt=con.prepareStatement(updateByBranchSql)){
			pstmt.setDouble(1, amount);
			pstmt.setString(2,branch);
			rowsUpdated=pstmt.executeUpdate();
			}catch(SQLException e) {
					e.printStackTrace();
				}
		return rowsUpdated;
	}
	

}
