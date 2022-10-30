/**
 * 
 */
package com.promineotech.application.dao;

import java.util.Optional;
import com.promineotech.application.entity.Classes;

/**
 * @author Joeit
 *
 */
public interface ClassesDao {

  Optional<Classes> createClass(String subject, Integer gradeYear);
  
  Optional<Classes> deleteClass(String classPk);
}
