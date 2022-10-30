/**
 * 
 */
package com.promineotech.application.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.application.entity.Student;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author Joeit
 *
 */

@Validated
@RequestMapping("/student")
@OpenAPIDefinition(info = @Info(title = "Final Project"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface StudentController {
//@formatter:off
// Get Method Swagger documentation for when client receives a GET REQUEST "/Student"
  @Operation(
      summary = "Returns a list of Students",
      description = "Returns a list of students given a required customer PK. Should only return a single student!",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A Student Object is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Student.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Students were found with that StudentPK.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "studentPK", 
              allowEmptyValue = false, 
              required = false, 
              description = "The studentPK (i.e., ' JOSITA1001 ')"), 
          
     }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Student> fetchStudent(
      @RequestParam(required = true)
      String studentPk);

  @Operation(
      summary = "Creates Student",
      description = "Returns Student when successfully created a student!",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "Student has been created", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Student.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "Unplanned error occured, Student could not be created!", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "firstName", 
              allowEmptyValue = false, 
              required = true, 
              description = "The students First Name (i.e., 'Joseph')"), 
          @Parameter(
              name = "lastName", 
              allowEmptyValue = false, 
              required = true, 
              description = "The students Last Name (i.e., 'Italico')"),
          @Parameter(
              name = "studentGrade", 
              allowEmptyValue = false, 
              required = true, 
              description = "The students grade year (i.e.,  12 )")
     }
  )
  @PostMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Student> createStudent(
      @RequestParam(required = true)
      String firstName,
      @RequestParam(required = true)
      String lastName,
      @RequestParam(required = true)
      Integer studentGrade
      );
 
  
  @Operation(
      summary = "Deletes a student from the Students table.",
      description = "Delete a student given a required student Primary key.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A student is deleted.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Student.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No students were found with that Primary Key.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "studentPk", 
              allowEmptyValue = false, 
              required = true, 
              description = "The student Primary Key (i.e., 'Joselico2344')"), 
      }
  )
   // Delete method (Delete)
   @DeleteMapping
   @ResponseStatus(code = HttpStatus.OK)
   Optional<Student> deleteStudent(
       @RequestParam(required = false) 
       String studentPk);
  
  @Operation(
      summary = "Update a students grade year.",
      description = "Update a students grade year given a required student Primary key and new year.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A student grade year is updated.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Student.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to update student grade year with the data.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "firstName", 
              allowEmptyValue = false, 
              required = true, 
              description = "The students First name (i.e., 'Joseph')"),
          @Parameter(
              name = "lastName", 
              allowEmptyValue = false, 
              required = true, 
              description = "The students last name (i.e., 'Italico')"),
          @Parameter(
              name = "studentPk", 
              allowEmptyValue = false, 
              required = true, 
              description = "The student Primary Key (i.e., 'Joselico2344')"),
          @Parameter(
              name = "studentGrade", 
              allowEmptyValue = false, 
              required = true, 
              description = "The student new grade year (i.e., ' 12 ')")
      })
  // Update method 
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Student> updateStudentYearGrade(
      @RequestParam(required = true)
      String firstName,
      @RequestParam(required = true)
      String lastName,
      @RequestParam(required = true)
      String studentPk,
      @RequestParam(required = true)
      Integer studentGrade);

  
      
}
