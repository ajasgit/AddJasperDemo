package com.ajas.jasper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ajas.jasper.model.Student;
@Service
public class StudentService {

	
	public static List<Student> generatedStudentList(){
		
		List<Student> student= new ArrayList<Student>();

				student.add(new Student(1,"Ajas","AR", "Chadayamangalam", "Kollam"));
				student.add(new Student(2,"Zayan","Hamiz", "Kadakkal", "Kollam"));
		
				
				
				return student;
			
			
		
		
	}
	
}
