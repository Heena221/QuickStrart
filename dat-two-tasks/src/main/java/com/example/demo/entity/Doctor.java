package com.example.demo.entity;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name="doctor")

public class Doctor {
	@Id
	private int id;
	
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="department")
	private String department;
	
	//one doctor has many patients one to many
	@OneToMany(targetEntity = Patient.class,fetch=FetchType.EAGER ,cascade = CascadeType.ALL)
	@JoinColumn(name="doctor_ref",referencedColumnName = "id")
	Set<Patient> patientList;

}
