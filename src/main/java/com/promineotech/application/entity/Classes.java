/**
 * 
 */
package com.promineotech.application.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
// create
public class Classes {
  private String classPK;
  private String subject;
  private Integer gradeYear;
}



