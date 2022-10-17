
package com.example.demo.controller;



import java.util.Arrays;
import java.util.List;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {
        
    @GetMapping("/api/v1/students")
    public List<String> getNames(){
        return Arrays.asList("Ram","Shyam");
    }
}