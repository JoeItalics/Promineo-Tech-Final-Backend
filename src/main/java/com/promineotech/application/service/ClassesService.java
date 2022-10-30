/**
 * 
 */
package com.promineotech.application.service;

import java.util.Optional;
import com.promineotech.application.entity.Classes;

/**
 * @author Joeit
 *
 */
public interface ClassesService {
  
  Optional<Classes> createClass(String subject, Integer gradeYear);
  
  Optional<Classes> deleteClass(String classPk);

}
