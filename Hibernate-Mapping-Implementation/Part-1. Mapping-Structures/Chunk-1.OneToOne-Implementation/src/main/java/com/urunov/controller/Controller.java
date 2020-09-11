package com.urunov.controller;

import com.urunov.model.Laptop;
import com.urunov.model.Student;
import com.urunov.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: apple
 * @created on 10/09/2020
 * @Project is Mapping-One2One
 */
@RestController
@RequestMapping("/rest/users/")
public class Controller {

    @Autowired
   private StudentRepository studentRepository;

    @GetMapping(value = "/all")
    public List<Student> getStudent(){
        return (List<Student>) studentRepository.findAll();
    }


    @GetMapping(value = "/update/{name}")
    public List<Student>  update(@PathVariable final String name){

        Student student = new Student();

        Laptop laptop = new Laptop();
        laptop.setLname("Mac");


        student.setName("Hamdamboy")
                .setMark(90)
                .setLaptop(laptop)
                .setName(name);

        studentRepository.save(student);

        return (List<Student>) studentRepository.findAll();



    }
}
