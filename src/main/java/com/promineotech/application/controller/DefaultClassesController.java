/**
 * 
 */
package com.promineotech.application.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.application.entity.Classes;
import com.promineotech.application.service.ClassesService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joeit
 *
 */
@RestController
@Slf4j
public class DefaultClassesController implements ClassesController {

  @Autowired
  private ClassesService classesService;
  
  
  
  @Override
  public Optional<Classes> createClass(String subject, Integer gradeYear) {
    log.info("Create class method called with subject = {}, gradeYear = {}", subject, gradeYear);
    
    return classesService.createClass(subject, gradeYear);
  }

  @Override
  public Optional<Classes> deleteClass(String classPk) {
    log.info("Delete class method called with class Primary key = {}", classPk);
    return classesService.deleteClass(classPk);
  }

}
