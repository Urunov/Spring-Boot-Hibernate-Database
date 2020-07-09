package spring.country.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.country.model.Contact;
import spring.country.model.ContactDto;
import spring.country.model.People;
import spring.country.repository.ContactRepository;
import spring.country.repository.PeopleDAO;
import spring.country.service.PeopleService;

import javax.validation.Valid;
import java.util.List;

/**
 * @Created 12 / 06 / 2020 - 5:13 PM
 * @project SpringBootPeople
 * @Author Hamdamboy
 */
@Controller
public class PeopleControleer {

    @Autowired
        private PeopleService peopleService;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    PeopleDAO peopleDAO;

    @GetMapping("/add")
    public String addPage(Model model){

        model.addAttribute("people", peopleService.createPeople());
        return "add_new_person";
   }


    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("people") People people, BindingResult bindingResult, Model model){

        int i = 1;
        if(bindingResult.hasErrors()){
            model.addAttribute("errorMessage", "The submitted data has errors.");
        } else {
            for(Contact contact: people.getContactList()){
                contact.setSequenceNumber(i);
                i++;
            }

            model.addAttribute("people", peopleService.save(people));
            model.addAttribute("successMessage", "Person saved successfully!");
        }
        peopleService.save(people);
        // return "redirect:/";
        return "list_people";
    }

    @GetMapping("/people/{id}")
    public String getForm(Model model, @PathVariable(required = false, name = "id") long id) {

        model.addAttribute("person", peopleDAO.findById(id));
        ContactDto contactDto = new ContactDto();
        contactDto.setContacts(contactRepository.getContactsByPersonId(id));
        model.addAttribute("contactDto", contactDto);
        return "index2";
    }


    @PostMapping("/people")
    public String edit(@Valid People people, BindingResult bindingResult, RedirectAttributes redirAttrs, Model model) {
        int i=1;
        ContactDto contactDto = new ContactDto();
        contactDto.setContacts(contactRepository.getContactsByPersonId(people.getId()));
        model.addAttribute("contactDto", contactDto);

        if (bindingResult.hasErrors()) {
            redirAttrs.addFlashAttribute("errorMessage", "The submitted data has errors.");
//            model.addAttribute("errorMessage", "The submitted data has errors.");
        } else {
            for (Contact cnct : people.getContactList()) {
                cnct.setSequenceNumber(i);
                i++;
            }
            model.addAttribute("person", peopleService.save(people));
            redirAttrs.addFlashAttribute("successMessage", "Person saved successfully!");
//            model.addAttribute("successMessage", "Person saved successfully!");
        }

        return "redirect:/people/" + people.getId();
    }

    @GetMapping("/list")
    public String List(Model model){

        List<People> people = peopleService.getAllPeople();

        model.addAttribute("people", people);

        return findPaginated(1, "firstName", "asc", model);

    }

//    @RequestMapping(value = { "list" }, method = RequestMethod.GET)
//    public String listUsers(ModelMap model) {
//        List<People> peopleList = peopleService.getAllPeople();
//        model.addAttribute("peopleList", peopleList);
//        model.addAttribute("metaTitle", "All Users");
//        return "list_people";
//    }

    @PostMapping("/addContact")
    public String addContact(People person) {
        peopleService.addContact(person);
        return "index :: contacts"; // returning the updated section
    }

    //    @SuppressWarnings("unlikely-arg-type")
    @PostMapping("/removeContact")
    public String removeContact(People people, @RequestParam("removeDynamicRow") Integer contactIndex) {
//    	person.getContactList().remove(contactIndex);
        //personService.removeContact(person, contactIndex);
        peopleService.removeContact(people, contactIndex);
        return "index :: contacts"; // returning the updated section
    }




    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable (name = "id") int id){
        ModelAndView modelAndView = new ModelAndView("edit_form");
       // People people = peopleDAO.getOne(id);

        People people = peopleService.getPeopleId(id);

        modelAndView.addObject("people", people);

        return modelAndView;
    }

    @PostMapping("/update")

    public String update(@ModelAttribute("people") People people){
       // peopleDAO.saveAndFlush(people);
        peopleService.save(people);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
       // peopleDAO.deleteById(id);

        peopleService.deletePeopleById(id);
        return "redirect:/";
    }

//    @GetMapping("/search")
//    public String searchPeople(Model model, @Param("keyword") String keyword) {
//
//        //List<People> peopleList = peopleDAO.findAll();
//        List<People> peopleList = peopleService.getAllPeople();
//        model.addAttribute("peopleList", peopleList);
//        model.addAttribute("keyword", keyword);
//
//        return "search";
//    }




    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {

        int pageSize = 5;

        Page<People> page = peopleService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<People> peoples = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalPages());

        model.addAttribute("sortFiled", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc": "asc");

        model.addAttribute("peoples", peoples);

        return "list_people";
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


    @GetMapping("/search")
    public String search(Model model) {

        return "search";
    }

    @RequestMapping(value = "/persons/{firstName}", method = RequestMethod.GET)
    public String showGuestList(Model model, @PathVariable("firstName") String firstName) {
        model.addAttribute("persons", peopleDAO.findByFirstNameIgnoreCaseContaining(firstName));

        return "search :: search";
    }


}

