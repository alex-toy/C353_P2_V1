package emiage.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import emiage.entity.Person;
import emiage.service.PropertyService;
import emiage.service.StudentService;
import emiage.service.PersonService;

@Controller
@RequestMapping("/property")
public class PropertyController {
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private PersonService personService;
	
	
	public boolean deletableProperty(Property property) {
		int NbRenters = property.getRenters().size();
		if(NbRenters > 0) {return false;}
		return true;
	}
	
	
	@GetMapping("/listProperties")
	public String listProperties(Model theModel) {
		
		List<Property> properties = propertyService.getProperties();
		theModel.addAttribute("properties", properties);
		
		HashMap<Integer, Boolean> deletables = new HashMap<Integer, Boolean>();
		for(Property property : properties) {
			if(deletableProperty(property)) {deletables.put(property.getId(), true);}
			else {deletables.put(property.getId(), false);}
		}
		System.out.println(deletables);
		theModel.addAttribute("deletables", deletables);
		
		return "list-properties";
	}
	
	
	@GetMapping("/addPropertyForm")
	public String addPropertyForm(Model theModel) {
		
		Property theProperty = new Property();
		theModel.addAttribute("property", theProperty);
		return "property-form";
	}
	
	
	@PostMapping("/saveProperty")
	public String saveProperty(
			@Valid @ModelAttribute("property") Property theProperty,
			BindingResult theBindingResult) {
		
		if (theBindingResult.hasErrors()) {
			return "property-form";
		}
		propertyService.saveProperty(theProperty);	
		return "redirect:/property/listProperties";
	}
	
	
	@GetMapping("/updatePropertyForm")
	public String updatePropertyForm(
			@RequestParam("propertyId") int propertyId,
			Model theModel) {
		
		Property property = propertyService.getProperty(propertyId);
		
		List<Person> persons = personService.getPersons();	
		theModel.addAttribute("persons", persons);
		theModel.addAttribute("property", property);
		return "update-property-form";
	}
	
	
	@PostMapping("/updateProperty")
	public String updateProperty(
			@Valid @ModelAttribute("property") Property property,
			BindingResult theBindingResult,
			Model theModel) {
		
		if (theBindingResult.hasErrors()) {
			return "update-property-form";
		}
		propertyService.saveProperty(property);	
		return "redirect:/property/listProperties";
	}
	
	
	@GetMapping("/detailProperty")
	public String detailProperty(@RequestParam("propertyId") int theId, Model theModel) {
		
		Property property = propertyService.getProperty(theId);
		theModel.addAttribute("property", property);
		
		List<Person> renters = personService.getPersons();
		theModel.addAttribute("renters", renters);
		
		return "detail-property";
	}
	
	
	@GetMapping("/addRenter")
	public String addRenter(
			@RequestParam("renterId") int renterId,
			@RequestParam("propertyId") int propertyId) {
		
		Property property = propertyService.getProperty(propertyId);
		Student renter = studentService.getStudent(renterId);	
		
		property.add(renter);
		propertyService.saveProperty(property);
		
		renter.setRented_property(property);
		personService.savePerson(renter);
		
		return "redirect:/property/detailProperty/?propertyId=" + propertyId;
	}
	
	
	@GetMapping("/deleteProperty")
	public String deleteProperty(@RequestParam("propertyId") int theId) {
		
		propertyService.deleteProperty(theId);
		return "redirect:/property/listProperties";
	}
}










