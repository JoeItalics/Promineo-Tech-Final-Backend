/**
 * 
 */
package com.promineotech.application.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.application.entity.Assignment;

/**
 * @author Joeit
 *
 */
public interface AssignmentDao {

  /**
   * @param assignmentName
   * @return
   */
  List<Assignment> fetchAssignments(String firstName, String lastName, String classId);

  Optional<Assignment> createAssignment(String assignmentName, String classId, String firstName, String lastName,
      Integer assignmentGrade);

}
