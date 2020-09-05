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
import emiage.entity.Person;
import emiage.service.PropertyService;
import emiage.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PropertyService propertyService;
	
	
	@GetMapping("/listPersons")
	public String listPersons(Model theModel) {
		
		List<Person> thePersons = personService.getPersons();
		theModel.addAttribute("persons", thePersons);
		return "list-persons";
	}
	
	
	@GetMapping("/addPersonForm")
	public String addPersonForm(Model theModel) {
		
		Person thePerson = new Person();
		theModel.addAttribute("person", thePerson);
		return "person-form";
	}
	
	
	@PostMapping("/savePerson")
	public String savePerson(
			@Valid @ModelAttribute("person") Person thePerson,
			BindingResult theBindingResult) {
		
		if (theBindingResult.hasErrors()) {
			return "person-form";
		}
		personService.savePerson(thePerson);	
		return "redirect:/person/listPersons";
	}
	
	
	@GetMapping("/updatePerson")
	public String updatePerson(@RequestParam("personId") int theId, Model theModel) {
		
		Person thePerson = personService.getPerson(theId);	
		theModel.addAttribute("person", thePerson);
		return "update-person-form";
	}
	
	
	@GetMapping("/detailPerson")
	public String detailPerson(@RequestParam("personId") int personId, Model theModel) {
		
		Person person = personService.getPerson(personId);
		theModel.addAttribute("person", person);
		
		List<Property> properties = propertyService.getProperties();
		theModel.addAttribute("properties", properties);
		
		return "detail-person";
	}
	
	
	
	@GetMapping("/deletePerson")
	public String deletePerson(@RequestParam("personId") int theId) {
		
		personService.deletePerson(theId);
		return "redirect:/person/listPersons";
	}
}










