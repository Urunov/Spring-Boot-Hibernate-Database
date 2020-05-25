package spring.orm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.orm.repositories.UserRepository;

/**
 * @Created 25 / 05 / 2020 - 2:44 PM
 * @project SpringHibernateMySQL
 * @Author Hamdamboy
 */

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/users")
    public String home(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }




}
