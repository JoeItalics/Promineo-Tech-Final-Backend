/**
 * 
 */
package com.promineotech.application.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.application.dao.StudentDao;
import com.promineotech.application.entity.Student;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultStudentService implements StudentService {
  
  @Autowired
  private StudentDao studentDao; // References the StudentDao Interface to communicate with our sql statements.

  // Get
  @Override
  public Optional<Student> fetchStudent(String studentPk) {
    log.info("Fetch Student function was called with Student Primary Key = {}", studentPk);
    return studentDao.fetchStudent(studentPk);
  }

  // Post
  @Override
  public Optional<Student> createStudent(String firstName, String lastName, Integer studentGrade) {
    log.info("Create Student function was called with Student First Name = {}" + " Last Name = {}", firstName, lastName);
    return studentDao.createStudent(firstName, lastName, studentGrade);
  }

  // Put
  @Override
  public Optional<Student> updateStudentYearGrade(String firstName, String lastName,String studentPk, Integer studentGrade) {
    log.info("Update Student Grade Year method called, name = {}, studentPk = {} studentGrade = {}", (firstName + " " + lastName), studentPk, studentGrade);
    return studentDao.updateStudentYearGrade(firstName, lastName, studentPk, studentGrade);
  }

  // Delete
  @Override
  public Optional<Student> deleteStudent(String studentPk) {
    log.info("Delete Student function was called with Student Primary Key = {}", studentPk);
    return studentDao.deleteStudent(studentPk);
  }



  
  
  



}
