package spring.country.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.country.model.People;
import spring.country.repository.PeopleDAO;
import spring.country.service.PeopleService;

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

    @GetMapping("/add")
    public String viewHomePage(Model model){

        People people = new People();
        model.addAttribute("people", people);
        return "add_new_person";
   }


    @PostMapping("/save")
    public String save(@ModelAttribute("people") People people){
         // peopleDAO.save(people);

        peopleService.save(people);
        return "redirect:/";
    }

//    @GetMapping("/list/page")
//    public String ListPagination(Model model){
//        return findPaginated(1, "firstName", "asc", model);
//
//    }

    @GetMapping("/list")
    public String List(Model model){

       // List<People> people = peopleDAO.findAll();
        List<People> people = peopleService.getAllPeople();

        model.addAttribute("people", people);
//        findPaginated(1, "firstName", "asc", model);
//        return "list_people";
        return findPaginated(1, "firstName", "asc", model);

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

    @GetMapping("/search")
    public String searchPeople(Model model, @Param("keyword") String keyword) {

        //List<People> peopleList = peopleDAO.findAll();
        List<People> peopleList = peopleService.getAllPeople();
        model.addAttribute("peopleList", peopleList);
        model.addAttribute("keyword", keyword);

        return "search";
    }

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
}

