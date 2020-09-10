package com.urunov.service;

import com.urunov.model.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

/**
 * @Author: apple
 * @created on 10/09/2020
 * @Project is Mapping-One2One
 */

@Component
public interface StudentService {

    Student saveStudent(Student student);
    Student findById(int rollno);
}
