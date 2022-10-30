/**
 * 
 */
package com.promineotech.application.dao;


import java.util.Optional;
import com.promineotech.application.entity.Student;

// Layout for our service layer to perform CRUD operation to our database Dao File.
public interface StudentDao {

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
