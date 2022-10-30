/**
 * 
 */
package com.promineotech.application.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.application.entity.StudentClasses;

/**
 * @author Joeit
 *
 */
public interface StudentClassesService {
  
  List<StudentClasses> fetchClasses(String studentPK);
  
  Optional<StudentClasses> createStudentClass(String studentPK, String classPk);
}
