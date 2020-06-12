package spring.people.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.people.model.People;
import spring.people.repository.PeopleDAO;

import java.util.List;

/**
 * @Created 12 / 06 / 2020 - 5:13 PM
 * @project SpringBootPeople
 * @Author Hamdamboy
 */
@Controller
public class PeopleControleer {

    @Autowired
    private PeopleDAO peopleDAO;

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<People> peopleList = peopleDAO.findAll();
        model.addAttribute("peopleList", peopleList);
        return "index";
    }

    @GetMapping("/new")
    public String showNewForm(Model model){
        People people = new People();
        model.addAttribute("people", people);

        return "new_form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("people") People people){

        peopleDAO.save(people);

        return "redirect:/";
    }

}
