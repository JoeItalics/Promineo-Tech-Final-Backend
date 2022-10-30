/**
 * 
 */
package com.promineotech.application.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.application.entity.Student;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joeit
 *
 */

// The Dao file will return the Student Objects
@Component
@Slf4j
public class DefaultStudentDao implements StudentDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Optional<Student> fetchStudent(String studentPk) {
    log.info("DAO: Fetch student method studentPk={}", studentPk);
    String sql = "SELECT * FROM Students WHERE StudentPk = :studentPk";
    Map<String, Object> params = new HashMap<>();
    params.put("studentPk", studentPk);
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new StudentResultSetExtractor()));
  }
  class StudentResultSetExtractor implements ResultSetExtractor<Student> {
    @Override
    public Student extractData(ResultSet rs) throws SQLException {
      rs.next();

      // @formatter:off
      return Student.builder()
          .firstName(rs.getString("firstName"))
          .lastName(rs.getString("lastName"))
          .studentPk(rs.getString("studentPk"))
          .gradeYear(rs.getInt("gradeYear"))
          .build();
      // @formatter:on

    }
  } 
  
    

  @Override
  public Optional<Student> createStudent(String firstName, String lastName, Integer studentGrade) {
    log.info("DAO: Create student method First Name = {}, Last Name = {} student grade = {}", firstName, lastName, studentGrade);
    String sql = "INSERT INTO Students(firstName, lastName, studentPk, gradeYear) VALUES(:firstName, :lastName, :studentPk, :gradeYear)";
    String studentPk =  studentPrimaryKeyStringGenerator(firstName, lastName);
    Map<String, Object> params = new HashMap<>();
    params.put("firstName", firstName);
    params.put("lastName", lastName);
    params.put("studentPk", studentPk);
    params.put("gradeYear", studentGrade);
    
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Student.builder()
        .firstName(firstName)
        .lastName(lastName)
        .studentPk(studentPk)
        .gradeYear(studentGrade)
        .build());
    
        
  }

  private String studentPrimaryKeyStringGenerator(String firstName, String lastName) {
    Random random = new Random();
    String studentPk = "";
    if(firstName.length() > 4 && lastName.length() > 4) {
      studentPk = firstName.substring(0,4) + lastName.substring(lastName.length() - 4) + random.nextInt(10000);
    } else {
      
      studentPk = firstName + random.nextInt(10000);
    }
    return studentPk;
    
  }

  @Override
  public Optional<Student> updateStudentYearGrade(String firstName, String lastName, String studentPk, Integer studentGrade) {
    log.info("DAO: Update Student Grade Year method called, name = {}, studentPk = {} studentGrade = {}", (firstName + " " + lastName), studentPk, studentGrade);
    String sql = "UPDATE Students SET gradeYear = :gradeYear WHERE studentPk = :studentPk";
    Map<String, Object> params = new HashMap<>();
    params.put("firstName", firstName);
    params.put("lastName", lastName);
    params.put("gradeYear", studentGrade);
    params.put("studentPk", studentPk);
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(
        Student.builder()
        .firstName(firstName)
        .lastName(lastName)
        .studentPk(studentPk)
        .gradeYear(studentGrade)
        .build());
  }

  @Override
  public Optional<Student> deleteStudent(String studentPk) {
    String sql = "DELETE FROM Students WHERE studentPk = :studentPk";
    Map<String, Object> params = new HashMap<>();
    params.put("studentPk", studentPk);
    jdbcTemplate.update(sql, params);
    
    
    return Optional.ofNullable(
        Student.builder()
        .studentPk(studentPk)
        .build());
    }
  }
