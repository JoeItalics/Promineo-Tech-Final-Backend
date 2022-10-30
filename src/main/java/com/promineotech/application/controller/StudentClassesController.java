/**
 * 
 */
package com.promineotech.application.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.application.entity.StudentClasses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/student-classes")
public interface StudentClassesController {
  @Operation(
      summary = "Returns a list of Classes the student is attending.",
      description = "Returns a list of students given a required customer PK. Should only return a single student!",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A List of Student Classes Object is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = StudentClasses.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Classes were found for the Student.", 
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
              required = false, 
              description = "The studentPK (i.e., 'JOSITA1001')"), 
          
     }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<StudentClasses> fetchClasses( // Return a list of studentClasses object.
      @RequestParam(required = true)
      String studentPk);
  
  @Operation(
      summary = "Creates a new relationship between a students Primary key and Class primary Key",
      description = "Returns a student classes object when successful.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A Student Classes Object is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = StudentClasses.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
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
              required = false, 
              description = "The student primary key (i.e., 'JOSITA1001')"),
          @Parameter(
              name = "classPk", 
              allowEmptyValue = false, 
              required = false, 
              description = "The class Primary key (i.e., 'MATH210-1')"),
          
     }
  )
  @PostMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<StudentClasses> createRelationShip( // Return a list of studentClasses object.
      @RequestParam(required = true)
      String studentPk,
      @RequestParam(required = true)
      String classPk);
  
      
  
  
  
}
