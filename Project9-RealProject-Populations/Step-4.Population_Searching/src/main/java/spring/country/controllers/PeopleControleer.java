package spring.country.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.country.model.People;
import spring.country.repository.PeopleDAO;

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

    @GetMapping("/add")
    public String viewHomePage(Model model){

        People people = new People();
        model.addAttribute("people", people);
        return "add_new_person";
   }


    @PostMapping("/save")
    public String save(@ModelAttribute("people") People people){
      //  peopleService.save(people);
          peopleDAO.save(people);
        return "redirect:/";
    }


    @GetMapping("/list")
    public String List(Model model){

        List<People> people = peopleDAO.findAll();

        model.addAttribute("people", people);
        return "list_people";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable (name = "id") int id){
        ModelAndView modelAndView = new ModelAndView("edit_form");
        People people = peopleDAO.getOne(id);

        modelAndView.addObject("people", people);

        return modelAndView;
    }

    @PostMapping("/update")

    public String update(@ModelAttribute("people") People people){
        peopleDAO.saveAndFlush(people);

        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        peopleDAO.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchPeople(Model model, @Param("keyword") String keyword) {

        List<People> peopleList = peopleDAO.findAll();
        model.addAttribute("peopleList", peopleList);
        model.addAttribute("keyword", keyword);

        return "search";
    }
}

