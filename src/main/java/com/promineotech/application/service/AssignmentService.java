/**
 * 
 */
package com.promineotech.application.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.application.entity.Assignment;

/**
 * @author Joeit
 *
 */
public interface AssignmentService {

  // Get method
  List<Assignment> fetchAssignments(String firstName, String lastName, String classId);

  // Post method
  Optional<Assignment> createAssignment(String assignmentName, String classId, String firstName,
      String lastName, Integer assignmentGrade);
}
