/**
 * 
 */
package com.promineotech.application.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
// CRUD
public class Student {
  private String studentPk;
  private String firstName;
  private String lastName;
  private Integer gradeYear;
}