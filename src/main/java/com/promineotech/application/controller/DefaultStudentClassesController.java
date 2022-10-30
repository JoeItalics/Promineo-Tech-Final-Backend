/**
 * 
 */
package com.promineotech.application.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.application.entity.StudentClasses;
import com.promineotech.application.service.StudentClassesService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joeit
 *
 */
@RestController
@Slf4j
public class DefaultStudentClassesController implements StudentClassesController {

  @Autowired
  private StudentClassesService studentClassesService;  
  
  @Override
  public List<StudentClasses> fetchClasses(String studentPk) {
    log.info("Fetch classes method was called with studentPk = {}", studentPk);
    // TODO Auto-generated method stub
    return studentClassesService.fetchClasses(studentPk);
  }

  @Override
  public Optional<StudentClasses> createRelationShip(String studentPk, String classPk) {
    log.info("Create Relationship function called with studentPk = {} and classPk = {}", studentPk, classPk);
    return studentClassesService.createStudentClass(studentPk, classPk);
  }

}
