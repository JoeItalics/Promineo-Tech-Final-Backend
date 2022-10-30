/**
 * 
 */
package com.promineotech.application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.application.dao.AssignmentDao;
import com.promineotech.application.entity.Assignment;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joeit
 *
 */
@Service
@Slf4j
public class DefaultAssigmentService implements AssignmentService {
  
  @Autowired
  private AssignmentDao assignmentDao;
  
  // Get
  @Override
  public List<Assignment> fetchAssignments(String firstName, String lastName, String classId) {
    log.info("Fetch Assigments was called with first name = {},  lastName = {} classId = {}", firstName, lastName, classId);
    return assignmentDao.fetchAssignments(firstName, lastName, classId);
  }
  // Post
  @Override
  public Optional<Assignment> createAssignment(String assignmentName, String classId,
      String firstName, String lastName, Integer assignmentGrade) {
    log.info("Create Assigments was called with assigment name = {} classId = {} first name = {}, last name = {}", assignmentName, classId, firstName, lastName);
    return assignmentDao.createAssignment(assignmentName, classId, firstName, lastName, assignmentGrade);
  }

}
