package spring.people.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.people.model.People;
import spring.people.repository.PeopleDAO;
import spring.people.service.PeopleService;

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

    @GetMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword){

        List<People> peopleList = peopleService.listAll(keyword);
        model.addAttribute("peopleList", peopleList);
        model.addAttribute("keyword", keyword);

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

        peopleService.save(people);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable (name = "id") int id){
        ModelAndView modelAndView = new ModelAndView("edit_form");
        People people = peopleService.get(id);

        modelAndView.addObject("people", people);

        return modelAndView;
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("people") People people){
        peopleService.saveAndFlush(people);

        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        peopleService.delete(id);
        return "redirect:/";
    }

}
