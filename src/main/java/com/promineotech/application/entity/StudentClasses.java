/**
 * 
 */
package com.promineotech.application.entity;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class StudentClasses {
  private String studentPk;
  private String classPk;
  
}
