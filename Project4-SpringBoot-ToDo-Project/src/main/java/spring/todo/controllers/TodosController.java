package spring.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.todo.model.Todo;
import spring.todo.service.TodoService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Created 26 / 05 / 2020 - 11:07 AM
 * @project SpringToDo
 * @Author Hamdamboy
 */
@Controller
public class TodosController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/all-todos")
    public String allTodos(HttpServletRequest request){
        request.setAttribute("todos", todoService.findAll());
        request.setAttribute("mode", "MODE_TODOS");
        return "index";
    }

    @GetMapping("/new-todo")
    public String newTodo(HttpServletRequest request){
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @PostMapping("/save_todo")
    public String saveTodo(@ModelAttribute Todo todo, BindingResult bindingResult, HttpServletRequest request){
        todo.setDateCreate(new Date());
        todoService.save(todo);
        request.setAttribute("todos", todoService.findAll());
        request.setAttribute("mode", "MODE_UPDATE");
        return "index";
    }


  /* @PostMapping("/save_todo")
    public String saveTodo(@RequestParam String name, String description, Date date, @ModelAttribute HttpServletRequest request){

        Todo todo = new Todo();
        todo.setName(name);
        todo.setDescription(description);
        todo.setDateCreate(date);
        todoService.save(todo);
        request.setAttribute("todos", todoService.findAll());
        request.setAttribute("mode", "MODE_TODOS");
        return "index";
    }
    */

    @GetMapping("/update-todo")
    public String updateTodo(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("todo", todoService.findTodo(id).get());
        request.setAttribute("mode", "MODE_UPDlATE");
        return "index";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id, HttpServletRequest request){
        todoService.delete(id);
        request.setAttribute("todos", todoService.findAll());
        request.setAttribute("mode", "MODE_TODOS");
        return "index";
    }
}