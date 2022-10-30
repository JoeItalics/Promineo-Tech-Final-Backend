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
import com.promineotech.application.entity.Assignment;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joeit
 *
 */
@Component
@Slf4j
public class DefaultAssignmentDao implements AssignmentDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  
  @Override
  public List<Assignment> fetchAssignments(String firstName, String lastName, String classId) {
    log.info("DAO: Fetch assignments method was called with first name = {}, last name = {}, Class ID = {}", firstName, lastName, classId);
   
    String sql = "SELECT * FROM Assignments WHERE firstName = :firstName AND lastName = :lastName AND classId = :classId";
    Map<String, Object> params = new HashMap<>();
    params.put("firstName", firstName);
    params.put("lastName", lastName);
    params.put("classId", classId);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
           @Override
           public Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {
             //@formatter:off
             return Assignment.builder()
                 .assigmentName(rs.getString("assignmentName"))
                 .classId(rs.getString("classId"))
                 .firstName(rs.getString("firstName"))
                 .lastName(rs.getString("lastName"))
                 .assignmentGrade(rs.getInt("assignmentGrade"))
                 .build();
             //@formatter:on
           }});
       }

  @Override
  public Optional<Assignment> createAssignment(String assignmentName, String classId,
      String firstName, String lastName, Integer assignmentGrade) {
    log.info("DAO: Create Assignments method was called with assignmentName = {} classId = {} firstName = {}, lastName = {}, assignmentGrade = {}", assignmentName, classId, firstName, lastName, assignmentGrade);
    String sql = "INSERT INTO Assignments(assignmentName, classId, firstName, lastName, assignmentGrade) VALUES(:assignmentName, :classId, :firstName, :lastName, :assignmentGrade)";
    Map<String, Object> params = new HashMap<>();
    params.put("assignmentName", assignmentName);
    params.put("classId", classId);
    params.put("firstName", firstName);
    params.put("lastName", lastName);
    params.put("assignmentGrade", assignmentGrade);
    
    jdbcTemplate.update(sql, params); // Execute sql into db
    
    return Optional.ofNullable(Assignment.builder()
        .assigmentName(assignmentName)
        .classId(classId)
        .firstName(firstName)
        .lastName(lastName)
        .assignmentGrade(assignmentGrade)
        .build());
  }

}
