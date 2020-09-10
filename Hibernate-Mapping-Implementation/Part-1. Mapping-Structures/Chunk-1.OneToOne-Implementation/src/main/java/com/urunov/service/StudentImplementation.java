package com.urunov.service;

import com.urunov.model.Laptop;
import com.urunov.model.Student;
import com.urunov.repository.LaptopRepository;
import com.urunov.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: apple
 * @created on 10/09/2020
 * @Project is Mapping-One2One
 */
@Service
public class StudentImplementation implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
       student = studentRepository.save(student);

        return student;
    }


    public Student findById(int rollno) {
        Student st = studentRepository.findById(rollno);
        return st;
    }
}