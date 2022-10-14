package com.example.demo;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Hospital;
import com.example.demo.entity.Patient;
import com.example.demo.services.DoctorService;
import com.example.demo.services.HospitalServices;



@SpringBootApplication
public class DatTwoTasksApplication  {
	
	@Autowired
	HospitalServices hospitalServices;
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext	ctx=SpringApplication.run(DatTwoTasksApplication.class, args);
		Hospital obj=ctx.getBean("h4",Hospital.class);
		HospitalServices service=ctx.getBean(HospitalServices.class);
		//Doctor doctor=ctx.getBean(Doctor.class);
		DoctorService service1=ctx.getBean(DoctorService.class);
	   
		Doctor found=service1.findById(111);
		System.out.println("Doctor Name is "+found.getDoctorName());
		System.out.println("Doctor Department is "+found.getDepartment());
		
		System.out.println("List of patients");
		for(Patient eachPatient:found.getPatientList()) {
			System.out.println(eachPatient);
		}
		
	
	int key=3;
	switch (key) {
	
	case 1://save()
		System.out.println("Hospital details "+service.save(obj));
		break;
		
	case 2://findAll()
		service.findAll().forEach(System.out::println);
		break;
		
	case 3://findById(id)
		service.findById(104).forEach(System.out::println);
		break;
		
	case 4://update(entity)
		Hospital objToUpdate=ctx.getBean("updateBean",Hospital.class);
		service.update(objToUpdate);
		break;
		
	case 5://deleteById(id)
		service.deleteById(104);
		break;
		
	default:
		break;
	}
		
		ctx.close();
	}
	
	@Bean
	public Hospital h1() {
		return new Hospital(101, "Abc", 9845, "Goa");
	}
	@Bean
	public Hospital h2() {
		return new Hospital(102, "Xyz", 2345677, "Mumbai");
	}
	@Bean
	public Hospital h3() {
		return new Hospital(103, "AAA", 12345, "Delhi");
	}
	@Bean
	public Hospital h4() {
		return new Hospital(104, "ZZZZ", 987654, "Bly");
	}
	@Bean
	public Hospital updateBean() {
		return new Hospital(105,"Heen",12345678,"USA");
		
	}
//    @Bean
//    public CommandLineRunner runner() {
//    	return new CommandLineRunner() {
//			
//			@Override
//			public void run(String... args) throws Exception {
//				int numberOfRowsAffectedWhileUpdate=hospitalServices.update("XXX",101);
//				int numberOfRowsAffectedWhileDelete=hospitalServices.delete(104);
//				System.out.println("numberOfRowsAffectedWhileUpdate = "+numberOfRowsAffectedWhileUpdate);
//				System.out.println("numberOfRowsAffectedWhileDelete = "+numberOfRowsAffectedWhileDelete);
//				
//			}
//		};
//    }
		
	@Bean
	public Patient ram() {
		return new Patient(001, "Ram Kumar");
	}
	@Bean
	public Patient sham() {
		return new Patient(002, "Sham Kapoor");
	}
	
	@Bean
	public Doctor rajesh() {
		Set<Patient> patientList=new HashSet<>();
		patientList.add(ram());
		patientList.add(sham());
		return new Doctor(111, "Rajesh", "Cardiac", patientList );
	}
	

}
