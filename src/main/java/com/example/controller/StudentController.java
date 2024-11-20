package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.binding.Student;
import com.example.entity.StudentEntity;
import com.example.repo.StudentRepo;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepo repo;
	
	//Method to load student form
	@GetMapping("/")
	public String loadForm(Model model) {
		loadFormData(model);
		
		return "index";
	}

	private void loadFormData(Model model) {
		List<String> coursesList = new ArrayList<>();
		coursesList.add("Java");
		coursesList.add("Python");
		coursesList.add("AWS");
		coursesList.add("Devops");
		
		List<String> timingsList = new ArrayList<>();
		timingsList.add("Morning");
		timingsList.add("Afternoon");
		timingsList.add("Evening");
		//model is used to set the data from controller to UI
		model.addAttribute("courses", coursesList);
		model.addAttribute("timings", timingsList);
		
		Student student = new Student();
		model.addAttribute("student",student);
	}
	
	//Method to save student form data
	
	@PostMapping("/save")
	public String handleSubmit(Student s,Model model) {
		//logic to  save
		StudentEntity entity = new StudentEntity();
		
		//Copy data from binding object to entity object
		BeanUtils.copyProperties(s, entity);
		entity.setTimings(Arrays.toString(s.getTimings()));
		repo.save(entity);
		model.addAttribute("msg","Student data saved");
		loadFormData(model);
		return "index";
	}
	
	
	//Method to display saved students data
	
	

}
