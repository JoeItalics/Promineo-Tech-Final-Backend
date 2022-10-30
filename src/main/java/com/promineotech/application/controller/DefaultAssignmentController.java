/**
 * 
 */
package com.promineotech.application.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.application.entity.Assignment;
import com.promineotech.application.service.AssignmentService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joeit
 *
 */
@RestController
@Slf4j
public class DefaultAssignmentController implements AssignmentController {
  
  @Autowired
  private AssignmentService assignmentService;

  @Transactional
  @Override
  public List<Assignment> fetchAssignments(String firstName, String lastName, String classId){
    log.info("Controller: Fetch assignments method was called with first name = {}, last name = {}, Class ID = {}", firstName, lastName, classId);
    return assignmentService.fetchAssignments(firstName, lastName, classId);
  }
  
  @Override
  public Optional<Assignment> createAssignment(String assignmentName, String classId, String firstName, String lastName, Integer assignmentGrade){
    log.info("Controller: Create assignment method called with Assignment Name = {}, classId = {}, Student Name = {}, assignmentGrade = {}", assignmentName, firstName, lastName, assignmentGrade);
    return assignmentService.createAssignment(assignmentName, classId, firstName, lastName, assignmentGrade);    
  }
  
}
