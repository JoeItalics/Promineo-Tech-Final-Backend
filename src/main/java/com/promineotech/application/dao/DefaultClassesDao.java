/**
 * 
 */
package com.promineotech.application.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.application.entity.Classes;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joeit
 *
 */
@Component
@Slf4j 
public class DefaultClassesDao implements ClassesDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Optional<Classes> createClass(String subject, Integer gradeYear) {
    log.info("DAO: Create Class Method was called with subject = {}, grade Year = {}", subject, gradeYear);
    
    String classPk = subject + gradeYear;
    
    String sql = "INSERT INTO Classes(classPk, subject, gradeYear) VALUES(:classPk, :subject, :gradeYear)";
    Map<String, Object> params = new HashMap<>();
    params.put("classPk", classPk);
    params.put("subject", subject);
    params.put("gradeYear", gradeYear);
    
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Classes.builder()
        .classPK(classPk)
        .subject(subject)
        .gradeYear(gradeYear)
        .build());
  }

  @Override
  public Optional<Classes> deleteClass(String classPk) {
    String sql = "DELETE FROM Classes WHERE classPk = :classPk";
    Map<String, Object> params = new HashMap<>();
    params.put("classPk", classPk);
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Classes.builder()
        .classPK(classPk)
        .build());
  }

}
