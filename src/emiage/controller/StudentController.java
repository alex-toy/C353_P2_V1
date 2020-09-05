package emiage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import emiage.entity.Property;
import emiage.entity.Student;
import emiage.service.PropertyService;
import emiage.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private PropertyService propertyService;
	
	
	@GetMapping("/listStudents")
	public String listStudents(Model theModel) {
		
		List<Student> theStudents = studentService.getStudents();
		theModel.addAttribute("students", theStudents);
		return "list-students";
	}
	
	
	@GetMapping("/addStudentForm")
	public String addStudentForm(Model theModel) {
		
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}
	
	
	@PostMapping("/saveStudent")
	public String saveStudent(
			@Valid @ModelAttribute("student") Student theStudent,
			BindingResult theBindingResult) {
		
		if (theBindingResult.hasErrors()) {
			return "student-form";
		}
		studentService.saveStudent(theStudent);	
		return "redirect:/student/listStudents";
	}
	
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("studentId") int theId, Model theModel) {
		
		Student theStudent = studentService.getStudent(theId);	
		theModel.addAttribute("student", theStudent);
		return "update-student-form";
	}
	
	
	@GetMapping("/detailStudent")
	public String detailStudent(@RequestParam("studentId") int theId, Model theModel) {
		
		Student theStudent = studentService.getStudent(theId);
		theModel.addAttribute("student", theStudent);
		
		List<Property> properties = propertyService.getProperties();
		theModel.addAttribute("properties", properties);
		
		return "detail-student";
	}
	
	
	@GetMapping("/addStudentToRent")
	public String addStudentToRent(
			@RequestParam("studentId") int studentId,
			@RequestParam("propertyId") int propertyId) {
		
		Property property = propertyService.getProperty(propertyId);
		Student student = studentService.getStudent(studentId);	
		
		//property.add(student);
		propertyService.saveProperty(property);
		
		student.setRented_property(property);
		studentService.saveStudent(student);
		
		return "redirect:/student/detailStudent/?studentId=" + studentId;
	}
	
	
	@GetMapping("/stopLocationStudent")
	public String stopLocationStudent(
			@RequestParam("studentId") int studentId,
			@RequestParam("propertyId") int propertyId) {
		
		Property property = propertyService.getProperty(propertyId);
		Student student = studentService.getStudent(studentId);	
		
		//List<Student> test = property.getStudents();
		//test.remove(test.size()-1);
		
		//property.setStudents(test);
		propertyService.saveProperty(property);
		
		student.setRented_property(null);
		studentService.saveStudent(student);
		
		return "redirect:/student/detailStudent/?studentId=" + studentId;
	}
	
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		
		studentService.deleteStudent(theId);
		return "redirect:/student/listStudents";
	}
}










