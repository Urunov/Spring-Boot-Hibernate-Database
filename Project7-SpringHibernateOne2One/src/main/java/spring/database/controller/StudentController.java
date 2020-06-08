package spring.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.database.model.Student;
import spring.database.repository.StudentRepository;

import java.util.Date;
import java.util.List;

/**
 * @Created 08 / 06 / 2020 - 10:55 AM
 * @project SpringHibernateOne2One
 * @Author Hamdamboy
 */

@RestController
@RequestMapping("")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String index(){
        List<Student> halid = studentRepository.findAll();
        return "there is " + new Date() + "\n" + halid;
    }

    @GetMapping(params = "name")
    public Student filterByName(@RequestParam("name") String name){
        return studentRepository.findByName(name);
    }
}
