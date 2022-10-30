/**
 * 
 */
package com.promineotech.application.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.application.dao.ClassesDao;
import com.promineotech.application.entity.Classes;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joeit
 *
 */
@Service
@Slf4j
public class DefaultClassesService implements ClassesService {

  @Autowired
  private ClassesDao classesDao;
  
  @Override
  public Optional<Classes> createClass(String subject, Integer gradeYear) {
    log.info("Create class method called with subject = {} and grade year = {}", subject, gradeYear);
    return classesDao.createClass(subject, gradeYear);
  }

  @Override
  public Optional<Classes> deleteClass(String classPk) {
    log.info("Delete class method was called with class Primary key = {}", classPk);
    return classesDao.deleteClass(classPk);
  }

}
