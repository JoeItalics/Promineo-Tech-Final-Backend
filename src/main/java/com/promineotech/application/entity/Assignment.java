/**
 * 
 */
package com.promineotech.application.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder/**
   * @param firstName
   * @return
   */

//CRUD operations
public class Assignment {
  private String assigmentName;
  private String classId;
  private String firstName;
  private String lastName;
  private Integer assignmentGrade;// Forigen key on the student
  

  
}
