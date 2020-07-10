package com.thymeleaf.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thymeleaf.demo.model.Contact;
import com.thymeleaf.demo.model.ContactDto;
import com.thymeleaf.demo.model.Person;
import com.thymeleaf.demo.repository.ContactRepository;
import com.thymeleaf.demo.repository.PersonRepository;
import com.thymeleaf.demo.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	PersonRepository personRepository;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("person", personService.createPerson());
		return "index";
	}


	@PostMapping("/")
	public String save(@Valid Person person, BindingResult bindingResult, Model model) {
		int i = 1;
		if (bindingResult.hasErrors()) {
			model.addAttribute("errorMessage", "The submitted data has errors.");
		} else {
			for (Contact cnct : person.getContactList()) {
				cnct.setSequenceNumber(i);
				i++;
			}
			model.addAttribute("person", personService.savePerson(person));
			model.addAttribute("successMessage", "Person saved successfully!");
		}

		return "index";
	}

	@GetMapping("/person/{id}")
	public String getForm(Model model, @PathVariable(required = false, name = "id") Long id) {

		model.addAttribute("person", personRepository.findById(id));
		ContactDto contactDto = new ContactDto();
		contactDto.setContacts(contactRepository.getContactsByPersonId(id));
		model.addAttribute("contactDto", contactDto);
		return "index2";
	}

	@PostMapping("/person")
	public String edit(@Valid Person person, BindingResult bindingResult, RedirectAttributes redirAttrs, Model model) {
		int i = 1;
		ContactDto contactDto = new ContactDto();
		contactDto.setContacts(contactRepository.getContactsByPersonId(person.getId()));
		model.addAttribute("contactDto", contactDto);

		if (bindingResult.hasErrors()) {
			redirAttrs.addFlashAttribute("errorMessage", "The submitted data has errors.");
//            model.addAttribute("errorMessage", "The submitted data has errors.");
		} else {
			for (Contact cnct : person.getContactList()) {
				cnct.setSequenceNumber(i);
				i++;
			}
			model.addAttribute("person", personService.savePerson(person));
			redirAttrs.addFlashAttribute("successMessage", "Person saved successfully!");
//            model.addAttribute("successMessage", "Person saved successfully!");
		}

		return "redirect:/person/" + person.getId();
	}

	@RequestMapping(value = {"list"}, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<Person> persons = personService.findAllPersons();
		model.addAttribute("persons", persons);
		model.addAttribute("metaTitle", "All Users");
		return "list";
	}

	@PostMapping("/addContact")
	public String addContact(Person person) {
		personService.addContact(person);
		return "index :: contacts"; // returning the updated section
	}

	//    @SuppressWarnings("unlikely-arg-type")
	@PostMapping("/removeContact")
	public String removeContact(Person person, @RequestParam("removeDynamicRow") Integer contactIndex) {
//    	person.getContactList().remove(contactIndex);
		personService.removeContact(person, contactIndex);
		return "index :: contacts"; // returning the updated section
	}

	@RequestMapping(value = "/personDelete/{id}", method = RequestMethod.GET)
	public String notesDelete(Model model, @PathVariable(required = true, name = "id") Long id) {
		personRepository.deleteById(id);
//			model.addAttribute("listAppUser", appUserService.findAll());
		return "redirect:/list";
	}

	@GetMapping("/search")
	public String search(Model model) {
		return "search";
	}

	@RequestMapping(value = "/persons/{surname}", method = RequestMethod.GET)
	public String showGuestList(Model model, @PathVariable("surname") String surname) {
		model.addAttribute("persons", personRepository.findByFirstnameIgnoreCaseContaining(surname));

		return "search :: resultsList";
	}

	@GetMapping("/tabs")
	public String tabs(Model model) {
		return "tabs";
	}

	@GetMapping("/progress")
	public String progress(Model model) {
		return "progress";
	}

	@GetMapping("/jquery")
	public String jquery(Model model) {
		return "jquery";
	}

	@GetMapping("/jquery2")
	public String jquery2(Model model) {
		return "jquery2";
	}

	@GetMapping("/about")
	public String aboutCom() {
		return "about";
	}

	@GetMapping("/contact")
	public String ContactUs() {
		return "contact";
	}
}