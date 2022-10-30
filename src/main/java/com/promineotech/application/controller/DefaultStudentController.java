/**
 * 
 */
package com.promineotech.application.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.application.entity.Student;
import com.promineotech.application.service.StudentService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joeit
 *
 */
@RestController
@Slf4j
public class DefaultStudentController implements StudentController {
  
  @Autowired
  private StudentService studentService;
  
  @Transactional
  @Override
  public Optional<Student> fetchStudent(String studentPk) {
    log.info("Student get request for StudentPK={}", studentPk);
    return studentService.fetchStudent(studentPk);
  }
 
  @Override
  public Optional<Student> createStudent(String firstName, String lastName, Integer studentGrade) {
    log.info("Create student method called Student Name = {} {}", firstName + " ", lastName);
    return studentService.createStudent(firstName, lastName, studentGrade);
  }

  @Override
  public Optional<Student> deleteStudent(String studentPk) {
    log.info("Delete student method called for student Primary key = {}", studentPk);
    return studentService.deleteStudent(studentPk);
  }

  @Override
  public Optional<Student> updateStudentYearGrade(String firstName, String lastName, String studentPk, Integer studentGrade) {
    log.info("Update Student Grade Year method called, name = {}, studentPk = {} studentGrade = {}", (firstName + " " + lastName), studentPk, studentGrade);
    return studentService.updateStudentYearGrade(firstName, lastName, studentPk, studentGrade);
  }


  
}
