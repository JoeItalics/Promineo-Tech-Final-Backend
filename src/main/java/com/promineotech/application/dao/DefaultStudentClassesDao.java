/**
 * 
 */
package com.promineotech.application.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.application.entity.StudentClasses;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joeit
 *
 */
@Component
@Slf4j 
public class DefaultStudentClassesDao implements StudentClassesDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<StudentClasses> fetchClasses(String studentPk) {
    log.info("DAO: Fetch Classes method was called with studentPk = {}", studentPk);
    String sql = "SELECT * FROM StudentClasses WHERE studentPk = :studentPk";
    Map<String, Object> params = new HashMap<>();
    params.put("studentPk", studentPk);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public StudentClasses mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        return StudentClasses.builder()
            .studentPk(rs.getString("studentPk"))
            .classPk(rs.getString("classPk"))
            .build();
      }});};

  @Override
  public Optional<StudentClasses> createStudentClass(String studentPk, String classPk) {
    log.info("DAO: Create Student Classes Method was called with studentPk = {} and classPk = {}", studentPk, classPk);
    String sql = "INSERT INTO StudentClasses(studentPk, classPk) VALUES(:studentPk, :classPk)";
    Map<String, Object> params = new HashMap<>();
    params.put("studentPk", studentPk);
    params.put("classPk", classPk);
    jdbcTemplate.update(sql, params); // Execute sql into db
    
    return Optional.ofNullable(StudentClasses.builder()
        .studentPk(studentPk)
        .classPk(classPk)
        .build()
        );
    
  }

}
