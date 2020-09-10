package com.urunov.controller;

import com.urunov.model.Student;
import com.urunov.service.StudentImplementation;
import com.urunov.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: apple
 * @created on 10/09/2020
 * @Project is Mapping-One2One
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public Student saveStudent(@RequestBody Student student){
        Student studentResponse = studentService.saveStudent(student);
        return studentResponse;
    }

    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudentDetails(@PathVariable int rollno){
        Student studentResponse = studentService.findById(rollno);

        return studentResponse;
    }



}
