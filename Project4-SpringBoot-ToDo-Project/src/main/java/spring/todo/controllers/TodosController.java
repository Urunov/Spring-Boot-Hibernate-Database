package spring.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.todo.model.Todo;
import spring.todo.service.TodoService;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.Date;

/**
 * @Created 26 / 05 / 2020 - 11:07 AM
 * @project SpringToDo
 * @Author Hamdamboy
 */
@Controller
public class TodosController {

    // Validation code start
    boolean error = false;

    @Autowired
    private TodoService todoService;

    @GetMapping(name = "/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");

        return "index";
    }

    @GetMapping("/new-todo")
    public String newTodo(HttpServletRequest request){
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @PostMapping("/save-todo")
    public String saveTodo(@ModelAttribute Todo todo, BindingResult bindingResult, HttpServletRequest request, RedirectAttributes redirectAttributes){
        todo.setDateCreate(new Date());
        request.setAttribute("todos", todoService.findAll());
        request.setAttribute("mode", "MODE_UPDATE");
        request.setAttribute("mode", "MODE_NEW");
        todoService.save(todo);


            return "index";
    }



    @GetMapping("/update-todo")
    public String updateTodo(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("todo", todoService.findTodo(id).get());
        request.setAttribute("mode", "MODE_UPDATE");
        return "index";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id, HttpServletRequest request){
        todoService.delete(id);
        request.setAttribute("todos", todoService.findAll());
        request.setAttribute("mode", "MODE_TODOS");
        return "index";
    }

    @GetMapping("/all-todos")
    public String listAll(HttpServletRequest request){

        request.setAttribute("mode", "MODE_TODOS");
        request.setAttribute("todos", todoService.findAll());
        return "index";
    }


}


/***
 *      if (bindingResult.hasErrors()) {
 *             redirectAttributes.addFlashAttribute("message", "Failed");
 *             redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
 *             return "redirect:/";
 *         }
 *
 *         if (!bindingResult.hasErrors()) {
 *             redirectAttributes.addFlashAttribute("message", "Success");
 *             redirectAttributes.addFlashAttribute("alertClass", "alert-success");
 *             return "redirect:/";
 *         }
 *
 * */