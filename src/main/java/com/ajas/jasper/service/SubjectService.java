package com.ajas.jasper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ajas.jasper.model.Subject;

@Service
public class SubjectService {

public static List<Subject> generatedSubjectList(){
		
		List<Subject> subject= new ArrayList<Subject>();

		subject.add(new Subject("Java",80));
		subject.add(new Subject("MySql",70));
		subject.add(new Subject("PHP",50));
		subject.add(new Subject("Mongo",40));
		subject.add(new Subject("C++",60));
	
				
				
				return subject;
			
			
		
		
	}
	
}
