/**
 * 
 */
package com.promineotech.application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.application.dao.StudentClassesDao;
import com.promineotech.application.entity.StudentClasses;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joeit
 *
 */
@Service
@Slf4j
public class DefaultStudentClassesService implements StudentClassesService {

  @Autowired
  private StudentClassesDao studentClassesDao;
  
  @Override
  public List<StudentClasses> fetchClasses(String studentPk) {
    log.info("Fetch classes was called with studentPk = {}", studentPk);
    return studentClassesDao.fetchClasses(studentPk);
  }

  @Override
  public Optional<StudentClasses> createStudentClass(String studentPk, String classPk) {
    log.info("Create student classes function called with studentPk = {}, classPk = {}", studentPk, classPk);
    return studentClassesDao.createStudentClass(studentPk, classPk);
  }

}
