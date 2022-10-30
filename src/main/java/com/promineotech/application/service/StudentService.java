/**
 * 
 */
package com.promineotech.application.service;

import java.util.Optional;
import com.promineotech.application.entity.Student;

/**
 * @author Joeit
 *
 */
// Student Service Interface is the structure for the DefaultStudentService that connects to the StudentDao interface.
public interface StudentService {
  
  // Get Request.
  Optional<Student> fetchStudent(String studentPK);
  
  // Post Request.
  Optional<Student> createStudent(String firstName, String lastName, Integer studentGrade);
  
  // put Request.
  Optional<Student> updateStudentYearGrade(String firstName, String lastName, String studentPk,
      Integer studentGrade);
  
  // delete Request.
  Optional <Student> deleteStudent(String studentPk);




  
  
  
}
