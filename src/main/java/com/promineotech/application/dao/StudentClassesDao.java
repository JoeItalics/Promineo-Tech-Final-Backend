/**
 * 
 */
package com.promineotech.application.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.application.entity.StudentClasses;

/**
 * @author Joeit
 *
 */
public interface StudentClassesDao {
  
  List<StudentClasses> fetchClasses(String studentPK);
  
  Optional<StudentClasses> createStudentClass(String studentPK, String classPk);
  
}
