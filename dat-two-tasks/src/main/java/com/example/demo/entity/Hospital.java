package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="hospital")

public class Hospital {
	@Id
	int id;
	@Column(name="hospital_name")
	String hospitalName;
	
	@Column(name="mobile_number")
	long mobileNumber;
	
	@Column(name="hospital_address",length=20)
	String address;
}
